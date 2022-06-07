import MyTools.工具类.Sleeper;
import MyTools.工具类.StopWatch;
import MyTools.工具类.TimeTest;
import MyTools.我的数据结构.MyConcurrentCollection;
import MyTools.我的数据结构.多线程集合性能测试.ParallelCollectionTest;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

import static MyTools.工具类.FileTool.enumAllSubFiles;


/**
 * @author SWQXDBA
 */
interface NumGettable{
    int getNum();
}
class BigClass implements NumGettable{
    int num1;
    long num2;
    long num3;
    long num4;
    long num5;
    long num6;
    long num7;
    long num8;
    long num9;
    long num0;
    long num01;
    long num00;
    long num000;
    @Override
    public int getNum() {
        return num1;
    }
}
class SmallClass implements NumGettable{
    int num1;
    @Override
    public int getNum() {
        return num1;
    }
}
public class Main {
    static int count = 10000000;
    public static void main(String[] args) throws IOException {
        NumGettable[] datas = new NumGettable[count];
        for (int i = 0; i < count; i++) {
            datas[i] = new BigClass();
        }
        TimeTest.test(()->{
            test(datas);
        });




        NumGettable[] datas3 = new NumGettable[count];
        for (int i = 0; i < count; i++) {
            datas3[i] = new SmallClass();
        }
        TimeTest.test(()->{
            test(datas3);
        });


        NumGettable[] datas2 = new NumGettable[count];
        for (int i = 0; i < count; i++) {
            datas2[i] = new BigClass();
        }
        TimeTest.test(()->{
            test(datas2);
        });
    }
    public static void test(NumGettable[] datas){
        int max = 0;
        for (int i = 0; i < count; i++) {
            max = Math.max(max,datas[i].getNum());
        }
    }



}

