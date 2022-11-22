package MyTools.NIO;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class 文件读写 {
    //final static String FROM = "G:\\编程课程和资料\\源码前端后端整改文档.zip";
    final static String FROM = "src/笔试题/curblock-笔试-1504_人口、人口密度统计年鉴_20191113.xlsx";
    final static String TO = "src/笔试题/(2).xlsx";


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fun1();
        // fun2();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    static void fun1() {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get(FROM), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get(TO), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            long len = readChannel.size();
            long position = readChannel.position();
            //数据传输
            readChannel.transferTo(position, len, writeChannel);
            //效果和transferTo 一样的
            //writeChannel.transferFrom(readChannel, position, len, );
            readChannel.close();
            writeChannel.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static void fun2() {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get(FROM), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get(TO), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
            //数据传输
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
