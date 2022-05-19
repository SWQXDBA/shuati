package MyTools.我的数据结构;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class  MyConcurrentCollection <E> {
    int concurrentQuantity ;
    List<LinkedBlockingQueue<E>> collections = new ArrayList<>();

    Random random = new Random();

    public MyConcurrentCollection(int concurrentQuantity) {
        this.concurrentQuantity = concurrentQuantity;
        for (int i = 0; i < concurrentQuantity; i++) {
            collections.add(new LinkedBlockingQueue<>());
        }

    }

    public MyConcurrentCollection() {
        this(1);
    }
    private LinkedBlockingQueue<E> getNext(){
       return collections.get( random.nextInt(concurrentQuantity));
    }
    public void add(E element){
        getNext().add(element);
    }
    public E takeOne(){
        E remove = null;
        for (int i = random.nextInt(collections.size()) ; i < collections.size(); i++) {

            final LinkedBlockingQueue<E> collection = collections.get(i);
            if(i==collections.size()-1){
                i=-1;
            }
            if(collection.isEmpty()){
                continue;
            }
            try{
                remove  = collection.poll(100, TimeUnit.MILLISECONDS);
                if(remove!=null){
                    return remove;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    public synchronized int size(){
        int s = 0;
        for (LinkedBlockingQueue<E> collection : collections) {
            s+=collection.size();
        }
        return s;
    }
}
