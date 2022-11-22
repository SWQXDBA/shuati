package MyTools.多线程.自己的线程池1.Callable;

import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class MyCallableThreadPool<T> {
    volatile BlockingDeque<CallerMission<T>> callerMissions = new LinkedBlockingDeque<>();
    volatile BlockingDeque<CallerWorker<T>> callerWorkers = new LinkedBlockingDeque<>();
    HashMap<String, T> results = new HashMap<>();
    int listSize = 6;

    public MyCallableThreadPool() {
        listSize = Runtime.getRuntime().availableProcessors() + 1;
    }

    public MyCallableThreadPool(int listSize) {
        this.listSize = listSize;
    }

    public void addCaller(String name, Callable<T> callable) {
        callerMissions.add(new CallerMission<T>(name, callable));
        execute();
    }

    public T joinAndGet(String missionName) {
        while (!results.containsKey(missionName)) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return results.get(missionName);
    }

    public T tryGet(String missionName) {
        return results.get(missionName);
    }

    public void execute() {
        while (callerWorkers.size() < listSize && callerWorkers.size() < callerMissions.size()) {
            CallerWorker<T> callerWorker = new CallerWorker<>(callerMissions, callerWorkers, results);
            callerWorkers.add(callerWorker);
            callerWorker.start();
        }
    }

    //尝试关闭所有线程 需要等待线程当前任务完成。注意：此方法会关闭所有线程，导致任务不再执行。
    private void tryOverWorker() {
        for (CallerWorker<T> w : callerWorkers) {
            w.over();
        }
    }

    //关闭所有线程 并且可以返回结果
    public void join() {
        execute();
        try {
            while (!callerMissions.isEmpty()) {
                Thread.sleep(50);
            }
            tryOverWorker();
            while (!callerWorkers.isEmpty()) {
                Thread.sleep(50);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
