package 测试;

import MyTools.工具类.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List速度测试 {
    static int v = 100000;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        System.out.println("头插");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(0, i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(0, i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test2() {
        System.out.println("尾插");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test3() {
        System.out.println("中间插入");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }

        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < v; i++) {
            list.add(list2.size() / 2, i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < v; i++) {
            list2.add(list2.size() / 2, i);
        }
        System.out.println(stopWatch.getPassedMills());
    }

    public static void test4() {
        System.out.println("中间查找");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            list.add(i);
        }
        for (int i = 0; i < v; i++) {
            list2.add(i);
        }
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < 10000; i++) {
            list.get(v / 2 + i);
        }
        System.out.println(stopWatch.getPassedMills());
        stopWatch.restart();
        for (int i = 0; i < 10000; i++) {
            list2.get(v / 2 + i);
        }
        System.out.println(stopWatch.getPassedMills());
    }
}
