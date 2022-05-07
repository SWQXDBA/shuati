package 测试;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class 序列化 {
    static byte[] intToByteArray(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(value);
        return buffer.array();
    }

    static int byteArrayToInt(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer.getInt();
    }

    public static void main(String[] args) {
        main2();
    }

    public static void main2() {


        try {
            final Path of = Path.of("G:\\编程课程和资料\\新建文件夹", "file.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(of.toString());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new Entity());
            objectOutputStream.writeObject(new Date());
            objectOutputStream.writeObject(new Entity(77));


            FileChannel fileChannel = FileChannel.open(of, StandardOpenOption.READ, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(Math.toIntExact(Files.size(of)));
            fileChannel.read(buffer);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main1() {

        try {
            final Path of = Path.of("G:\\编程课程和资料\\新建文件夹", "file.txt");
            List<Entity> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(new Entity(i));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);

            FileChannel fileChannel =
                    FileChannel.open(of,
                            StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            for (Entity entity : list) {
                oos.writeObject(entity);

            }
            fileChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
            oos.close();
            fileChannel.close();

            FileChannel fileChannel2 =
                    FileChannel.open(of,
                            StandardOpenOption.READ);

            final ByteBuffer data = ByteBuffer.allocate(1024 * 1024);

            while (fileChannel2.read(data) != -1) {

                InputStream inputStream = new ByteArrayInputStream(data.array());
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {

                    final Object object = objectInputStream.readObject();
                    System.out.println(object);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                data.clear();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
