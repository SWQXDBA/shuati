package 测试;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Entity implements Serializable {
    int num1 = 66;
    int num2 = 66;
    long num3 = 12313;
    String name = "15124啊啊啊啊啊啊1421414515";
    Map<Integer, String> map = new LinkedHashMap<>();


    public Entity() {
        for (int i = 0; i < 10; i++) {
            map.put(i, new String(name));
        }
    }

    public Entity(int num1) {
        this();
        this.num1 = num1;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "num1=" + num1 +
                '}';
    }
}
