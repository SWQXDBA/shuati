package MyTools.工具类;

public class StopWatch {
    long start;

    public StopWatch() {
        start = System.nanoTime();
    }

    public long getPassedMills() {
        return (System.nanoTime() - start) / 1000_000;
    }

    public long getPassedNanosAndRestart() {
        final long l = System.nanoTime() - start;
        restart();
        return l;
    }

    public long getPassedNanos() {
        return System.nanoTime() - start;
    }

    public void start() {
        restart();
    }

    public void restart() {
        start = System.nanoTime();
    }
}
