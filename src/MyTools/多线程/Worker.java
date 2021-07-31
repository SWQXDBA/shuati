package MyTools.多线程;

import java.util.concurrent.BlockingDeque;

public class Worker extends Thread {
    final BlockingDeque<Mission> missions;
    BlockingDeque<Worker> ws;
    private boolean isOver = true;
    private boolean toOver = false;

    public Worker(BlockingDeque<Mission> queue, BlockingDeque<Worker> workers) {
        missions = queue;
        ws = workers;
    }

    @Override
    public void run() {
        while (!toOver) {
            isOver = false;
            Mission mission = missions.poll();
            if (mission != null)
                mission.doMission();
            isOver = true;
        }
        ws.remove(this);
    }

    //调用此方法后 会在执行完本次任务后结束该线程并且移出线程池
    public void over() {
        toOver = true;
    }

}
