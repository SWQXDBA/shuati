package MyTools.多线程.自己的线程池1.Callable;

import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class CallerWorker<T> extends Thread {
    BlockingDeque<CallerMission<T>> callerMissions = new LinkedBlockingDeque<>();
    BlockingDeque<CallerWorker<T>> ws;
    HashMap<String, T> results;
    private boolean isOver = true;
    private boolean toOver = false;

    public CallerWorker(BlockingDeque<CallerMission<T>> callerMissions, BlockingDeque<CallerWorker<T>> ws, HashMap<String, T> results) {
        this.callerMissions = callerMissions;
        this.ws = ws;
        this.results = results;
    }

    @Override
    public void run() {
        while (!toOver) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isOver = false;
            CallerMission<T> mission = callerMissions.poll();
            if (mission != null) {
                results.put(mission.name, mission.callMission());
            }

            isOver = true;
        }
        ws.remove(this);
    }

    public void over() {
        toOver = true;
    }
}
