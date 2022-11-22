package MyTools.多线程.自己的线程池1.普通任务;

import MyTools.我的数据结构.MySort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {
    volatile BlockingDeque<Mission> missions = new LinkedBlockingDeque<>();
    volatile BlockingDeque<Worker> workers = new LinkedBlockingDeque<>();

    int listSize = 6;

    public MyThreadPool(int listSize) {
        this.listSize = listSize > 0 ? listSize : 1;
    }

    public MyThreadPool() {
        //根据可用核心数创建线程
        listSize = Runtime.getRuntime().availableProcessors() + 1;
    }

    public static void pressTest(int count) {
        for (int threadCount = 1; threadCount <= Runtime.getRuntime().availableProcessors(); threadCount++) {
            MyThreadPool pool = new MyThreadPool(threadCount);
            Random random = new Random();
            Integer[] base_arr;
            base_arr = new Integer[5000];
            for (int j = 0; j < base_arr.length; j++) {
                base_arr[j] = Math.abs(random.nextInt() % 100);
            }
            System.out.println("start");
            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                pool.add(new Mission() {
                    @Override
                    public void doMission() {
                        MySort.quickSort(Arrays.copyOf(base_arr, base_arr.length), Integer::compare);
                        //  System.out.println(Arrays.toString(arr));
                    }
                });
            }

        }
    }

    public int getWorkerCount() {
        return workers.size();
    }

    public void resize(int newSize) throws MissionPollIsNotEmpty {
        if (!missions.isEmpty()) {
            throw new MissionPollIsNotEmpty();
        }
        this.listSize = newSize > 0 ? newSize : 1;
        if (workers.size() > listSize) {
            //尝试移除所有worker
            tryOverWorker();
        }
    }

    public void add(Mission mission) {
        missions.add(mission);
        execute();
    }

    //尝试关闭所有线程 需要等待线程当前任务完成。注意：此方法会关闭所有线程，导致任务不再执行。
    private void tryOverWorker() {
        for (Worker w : workers) {
            w.over();
        }
    }

    public void execute() {

        //尽量给每一个任务分配线程，并且不超过设定的值
        while (workers.size() < listSize && workers.size() < missions.size()) {
            Worker w = new Worker(missions, workers);
            w.start();
            workers.add(w);
        }

    }

    //阻塞并等待执行完所有任务 关闭所有线程
    public void join() {
        execute();
        try {
            while (!missions.isEmpty()) {
                Thread.sleep(50);
            }
                tryOverWorker();
                while (!workers.isEmpty()) {
                    Thread.sleep(50);
                }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clearMissions() {
        try {
            execute();
            while (!missions.isEmpty()) {
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //所有线程完成当前任务后强制终止
    public void closeIgnoreMission() {
        tryOverWorker();
        while (!workers.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MissionPollIsNotEmpty extends Throwable {


        public MissionPollIsNotEmpty() {

        }

        @Override
        public String toString() {
            return "MissionPollIsNotEmpty{}";
        }
    }
}
