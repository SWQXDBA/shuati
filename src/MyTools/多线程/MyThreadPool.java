package MyTools.多线程;

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

    //阻塞并等待执行完所有任务后清空线程池后继续
    public void clearThreads() {
        execute();
        while (!missions.isEmpty()) {
        }
        tryOverWorker();
        while (!workers.isEmpty()) {
        }
    }

    public void clearMissions() {
        execute();
        while (!missions.isEmpty()) {
        }

    }

    public boolean closeIgnoreMission() {
        tryOverWorker();
        while (!workers.isEmpty()) {
        }
        return true;
    }

    class MissionPollIsNotEmpty extends Exception {


        public MissionPollIsNotEmpty() {

        }

        @Override
        public String toString() {
            return "MissionPollIsNotEmpty{}";
        }
    }
}
