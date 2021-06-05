package 作业;

import java.util.LinkedList;
import java.util.Queue;

public class 最近请求的次数 {
    class RecentCounter {
        Queue<Integer> queue = new LinkedList<>();

        public RecentCounter() {
        }

        public int ping(int t) {
            queue.offer(t);
            int cnt = 0;

            while (t - queue.peek() > 3000) {
                queue.poll();
                cnt++;
            }

            return queue.size();

        }
    }
}
