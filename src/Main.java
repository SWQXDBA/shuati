import MyTools.工具类.Sleeper;
import MyTools.工具类.StopWatch;
import MyTools.我的数据结构.多线程集合性能测试.ParallelCollectionTest;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author SWQXDBA
 */
public class Main {

    static Person1 person1 = new Person1();

    static class Person1 {
        @Override
        public String toString() {
            return "Person1{" +
                    "value=" + value +
                    ", value2=" + value2 +
                    '}';
        }

        public Person1() {
            value = 1024;
            Sleeper.sleep(1000);
            value2 = 2048;
        }

        int value = 0;
        int value2 = 0;
    }

    public static void main(String[] args) {



        ParallelCollectionTest.testAll(10000,100);


        Sleeper.sleep(10000L);
    }


}

