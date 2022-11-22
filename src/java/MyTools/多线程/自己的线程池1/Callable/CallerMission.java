package MyTools.多线程.自己的线程池1.Callable;

import java.util.concurrent.Callable;

public class CallerMission<T> {
    String name;
    Callable<T> mission;

    public CallerMission(String name, Callable<T> mission) {
        this.name = name;
        this.mission = mission;
    }

    public T callMission() {
        T ret = null;
        try {
            ret = mission.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
