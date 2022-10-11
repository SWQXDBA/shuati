package MyReactor;

import java.util.function.Function;

public class One<T> implements Executor<T>,Unit<T>{
    private One<?> next;
    private One<?> first;
    private T just;
    private Function mapper;
    public <R> One<R> map(Function<T,R> mapper){
        One<R> rOne = new One<>();
        rOne.mapper = mapper;
        this.next = rOne;
        rOne.first = first;
        return rOne;
    }

    public static <T>One<T> just(T t){
        One<T> tOne = new One<>();
        tOne.just = t;
        tOne.first = tOne;
        return tOne;
    }
    @Override
    public T submit() {
        first.start();
        return this.just;
    }


    public T get(){
        return just;
    }
    public void start(){
        next(just);
    }
    @Override
    public void next(Object p) {
        if(mapper!=null){
            this.just = (T) mapper.apply(p);
        }else{
            this.just =(T) p;
        }
        if (next!=null) {

            next.next(this.just);
        }

    }
}
