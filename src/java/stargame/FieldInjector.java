package stargame;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FieldInjector {
    private static Map<String,Map<String,Field>> fromFieldMap = new ConcurrentHashMap<>();
    private static Map<String,Map<String,Field>> targetFieldMap = new ConcurrentHashMap<>();

    /**
     * 把from的属性注入进to 根据属性名字
     * @param from
     * @param to
     * @param <E>
     * @param <V>
     * @return
     */
    public static <E,V> V inject (E from,V to){
        var fields = from.getClass().getDeclaredFields();
        Map<String,Field> fromFields;
        final String entityClassName = from.getClass().getSimpleName();
        if(fromFieldMap.containsKey(entityClassName)){
            fromFields = fromFieldMap.get(entityClassName);
        }else{
            fromFields = new HashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                fromFields.put(field.getName(),field);
            }
            fromFieldMap.putIfAbsent(entityClassName,fromFields);
        }



        Map<String,Field> targetField;
        final String voClassName = to.getClass().getSimpleName();
        if(targetFieldMap.containsKey(voClassName)){
            targetField = targetFieldMap.get(voClassName);
        }else{
            targetField = new HashMap<>();

            for (Field declaredField : to.getClass().getDeclaredFields()) {
                //只有entity中有的filed才会被注入 因为vo中可能包含额外信息
                if(fromFields.containsKey(declaredField.getName())){
                    declaredField.setAccessible(true);
                    targetField.put(declaredField.getName(),declaredField);
                }
            }
            targetFieldMap.putIfAbsent(voClassName,targetField);
        }


        for (Map.Entry<String, Field> entry : targetField.entrySet()) {
            final Field value = entry.getValue();
            final String filedName = entry.getKey();
            try {
                value.set(to,fromFields.get(filedName).get(from));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return to;
    }
}
