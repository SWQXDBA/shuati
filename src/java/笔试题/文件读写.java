package 笔试题;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class 文件读写 {

    final static String FROM = "G:\\编程课程和资料\\源码前端后端整改文档.zip";
    // final static String FROM = "src/笔试题/curblock-笔试-1504_人口、人口密度统计年鉴_20191113.xlsx";
    final static String TO = "src/笔试题/(2).xlsx";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // doBySingleThread();
        doByThreads();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static void doBySingleThread() {
        try {

            final FileInputStream fileInputStream = new FileInputStream(FROM);
            final FileOutputStream fileOutputStream = new FileOutputStream(TO);

            //1mb buffer
            byte[] buffer = new byte[1024 * 1024];
            while (fileInputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void doByThreads() {
        try {
            final FileInputStream fileInputStream = new FileInputStream(FROM);
            final FileOutputStream fileOutputStream = new FileOutputStream(TO);
            final BlockingQueue<byte[]> emptyBuffers = new LinkedBlockingQueue<>();
            final BlockingQueue<byte[]> fullBuffers = new LinkedBlockingQueue<>();
            final int bufferSize = 3;
            for (int i = 0; i < bufferSize; i++) {
                //1mb buffer
                byte[] buffer = new byte[1024 * 1024];
                emptyBuffers.offer(buffer);
            }
            AtomicBoolean finish = new AtomicBoolean(false);

            final ExecutorService threadPool = Executors.newFixedThreadPool(3);

            threadPool.execute(() -> {
                while (true) {
                    try {
                        final byte[] buffer = emptyBuffers.take();
                        final int read = fileInputStream.read(buffer);
                        fullBuffers.offer(buffer);
                        if (read == -1) {
                            finish.set(true);
                            break;
                        }
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPool.execute(() -> {
                while (true) {
                    try {
                        final byte[] data = fullBuffers.poll(100, TimeUnit.MILLISECONDS);
                        if (data == null) {
                            if (finish.get()) {
                                break;
                            }
                        } else {
                            fileOutputStream.write(data);
                            emptyBuffers.offer(data);
                        }

                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            threadPool.shutdown();
            threadPool.awaitTermination(999, TimeUnit.DAYS);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
