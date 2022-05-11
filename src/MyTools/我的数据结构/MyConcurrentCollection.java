package MyTools.我的数据结构;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class  MyConcurrentCollection <E> {
    int concurrentQuantity ;
    List<Vector<E>> collections = new ArrayList<>();

    Random random = new Random();

    public MyConcurrentCollection(int concurrentQuantity) {
        this.concurrentQuantity = concurrentQuantity;
        for (int i = 0; i < concurrentQuantity; i++) {
            collections.add(new Vector<>());
        }

    }

    public MyConcurrentCollection() {
        this(1);
    }
    private Vector<E> getNextVector(){
       return collections.get( random.nextInt(concurrentQuantity));

    }
    public void add(E element){
        getNextVector().add(element);
    }
    public E takeOne(){
        E remove = null;
        for (Vector<E> collection : collections) {
            if(!collection.isEmpty()){
                try{
                    remove  = collection.remove(0);
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        return remove;
    }
    public synchronized int size(){
        int s = 0;
        for (Vector<E> collection : collections) {
            s+=collection.size();
        }
        return s;
    }
}
