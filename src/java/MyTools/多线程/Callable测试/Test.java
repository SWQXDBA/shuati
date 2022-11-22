package MyTools.多线程.Callable测试;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 5, 2};
        FutureTask<Integer[]> toArray = new FutureTask<>(() -> Arrays.stream(arr).boxed().toArray(Integer[]::new));
        Thread t1 = new Thread(toArray);
        t1.start();
        try {
            System.out.println(Arrays.toString(toArray.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
