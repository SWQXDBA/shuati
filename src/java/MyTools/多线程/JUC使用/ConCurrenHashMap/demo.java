package MyTools.多线程.JUC使用.ConCurrenHashMap;

import MyTools.工具类.Debugger;
import MyTools.工具类.RandomTool;
import MyTools.工具类.Sleeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class demo {
    public static void main(String[] args) {
        test4();
    }

    //使用单线程
    static void test1() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        String words = "abcde";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (char c : words.toCharArray()) {
                list.add(String.valueOf(c));
            }
        }
        Collections.shuffle(list);//打乱集合
        Debugger.debug("shuffle finished");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        for (String s : list) {
            lists.get(Math.toIntExact(RandomTool.getRandomABS(9))).add(s);
        }
        // System.out.println(lists);
        for (var l : lists) {
            for (String s : l) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for (var v : map.entrySet()) {
            System.out.println(v.getKey() + "  " + v.getValue());
        }
    }

    //使用多线程 错误示范
    //多个方法之间不能保证安全
    static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(6);
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        String words = "abcde";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (char c : words.toCharArray()) {
                list.add(String.valueOf(c));
            }
        }
        Collections.shuffle(list);//打乱集合
        Debugger.debug("shuffle finished");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        for (String s : list) {
            lists.get(Math.toIntExact(RandomTool.getRandomABS(9))).add(s);
        }
        // System.out.println(lists);
        Collection<Callable<Object>> tasks = new ArrayList<>();
        for (var l : lists) {

            tasks.add(() -> {
                for (String s : l) {
                    Integer cnt = map.get(s);
                    Sleeper.sleep(1);
                    if (cnt == null) {
                        map.put(s, 1);
                    } else {
                        map.put(s, cnt + 1);
                    }

                }
                return null;
            });

        }
        try {
            service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var v : map.entrySet()) {
            System.out.println(v.getKey() + "  " + v.getValue());
        }
    }

    //正确案例
    static void test3() {
        ExecutorService service = Executors.newFixedThreadPool(6);
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
        String words = "abcde";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (char c : words.toCharArray()) {
                list.add(String.valueOf(c));
            }
        }
        Collections.shuffle(list);//打乱集合
        Debugger.debug("shuffle finished");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        for (String s : list) {
            lists.get(Math.toIntExact(RandomTool.getRandomABS(9))).add(s);
        }
        // System.out.println(lists);
        Collection<Callable<Object>> tasks = new ArrayList<>();
        for (var l : lists) {

            tasks.add(() -> {
                for (String s : l) {

                    //当key不存在的时候 把value设置为function返回的对象(生成一个)
                    //如果key存在 则不再生成 而是直接返回已经有的对象
                    LongAdder adder = map.computeIfAbsent(s, s1 -> new LongAdder());
                    //在此处真正更新值 是原子操作
                    adder.increment();


                }
                return null;
            });

        }
        try {
            service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var v : map.entrySet()) {
            System.out.println(v.getKey() + "  " + v.getValue());
        }
    }

    //同理可以使用merge
    static void test4() {
        ExecutorService service = Executors.newFixedThreadPool(6);
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        String words = "abcde";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (char c : words.toCharArray()) {
                list.add(String.valueOf(c));
            }
        }
        Collections.shuffle(list);//打乱集合
        Debugger.debug("shuffle finished");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        for (String s : list) {
            lists.get(Math.toIntExact(RandomTool.getRandomABS(9))).add(s);
        }
        // System.out.println(lists);
        Collection<Callable<Object>> tasks = new ArrayList<>();
        for (var l : lists) {

            tasks.add(() -> {
                for (String s : l) {
                    //同理可用merge实现原子更新操作
                    //map.merge(s, 1, (integer, integer2) -> integer+integer2);
                    map.merge(s, 1, Integer::sum);
                }
                return null;
            });

        }
        try {
            service.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var v : map.entrySet()) {
            System.out.println(v.getKey() + "  " + v.getValue());
        }
    }
}
