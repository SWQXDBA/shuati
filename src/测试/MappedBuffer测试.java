package 测试;

import MyTools.工具类.Sleeper;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class MappedBuffer测试 {
    final static Path of = Path.of("G:\\编程课程和资料\\新建文件夹", "file.txt");

    public static void main(String[] args) {

        mapTest();
    }

    static void mapTest() {
        try {
            byte[] data = new byte[6];
            Arrays.fill(data, Byte.parseByte("1"));
            FileChannel fileChannel = FileChannel.open(of, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);


            final MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 1024, 1024);
            map.put(data);

            map.flip();
            //   fileChannel.write(map);
            map.rewind();

            //   fileChannel.write(map);


            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void noMapTest() {
        try {
            byte[] data = new byte[1024];
            FileChannel fileChannel = FileChannel.open(of, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);

            buffer.put(data);
            buffer.flip();
            fileChannel.write(buffer);
            Sleeper.sleep(5000);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
