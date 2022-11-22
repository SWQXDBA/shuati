package 作业.暑假21年;

import java.util.*;

public class 前K个高频单词 {

    static public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //注意这里建的是小堆 这样poll的时候会把最小的弹出去
                return o2.getValue() - o1.getValue() == 0 ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k)
                heap.poll();
        }
        List<String> ret = new ArrayList<>();
        while (!heap.isEmpty()) {
            ret.add(heap.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(str, 2));
    }


}
