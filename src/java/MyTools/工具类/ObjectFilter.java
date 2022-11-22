package MyTools.工具类;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ObjectFilter <T>{
    ConcurrentHashMap<String,Iterable<T>> caches = new ConcurrentHashMap<>();
    public Iterable<T> filterBy(Iterable<T> iterator, Predicate<T> predicate,String predicateKey){
        final Iterable<T> cache = caches.get(predicateKey);
        if(cache!=null){
            return cache;
        }
        final LinkedList<T> list = new LinkedList<>();
        iterator.forEach((t)->{
            if(predicate.test(t)){
                list.add(t);
            }
        });
        caches.put(predicateKey,list);
        return list;
    }
    public void flush(String predicateKey){
        caches.remove(predicateKey);
    }

}
