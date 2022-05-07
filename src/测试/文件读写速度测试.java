package 测试;

import MyTools.工具类.StopWatch;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 文件读写速度测试 {
    static byte[] data = new byte[1024];//7032400

    public static void main(String[] args) {
        splitWrite();
    }

    static void splitWrite() {
        int cnt = 10000;
        final ExecutorService service = Executors.newFixedThreadPool(6);

        AtomicInteger finish = new AtomicInteger(cnt);
        BlockingQueue<ByteBuffer> bufferPool = new LinkedBlockingQueue<>();
        for (int i = 0; i < cnt / 10 + 1; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);

            bufferPool.offer(buffer);
        }

        BlockingQueue<Path> queue = new LinkedBlockingQueue<>();
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                while (true) {
                    try {
                        final Path take = queue.poll(10, TimeUnit.MILLISECONDS);
                        if (take == null) {
                            if (finish.get() <= 0) {
                                service.shutdown();
                                break;
                            }
                        } else {
                            Files.deleteIfExists(take);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        for (int i = 0; i < cnt; i++) {
            int finalI = i;
            int finalI1 = i;
            service.execute(() -> {
                final Path of;
                if (finalI1 % 2 == 0) {
                    of = Path.of("G:\\编程课程和资料\\新建文件夹", "file" + finalI + ".txt");
                } else {
                    of = Path.of("C:\\Users\\SWQXDBA\\Desktop\\新建文件夹 (2)", "file" + finalI + ".txt");
                }
                try {
                    StopWatch stopWatch2 = new StopWatch();

                    AsynchronousFileChannel channel =
                            AsynchronousFileChannel.open(of, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                    final ByteBuffer buffer = bufferPool.take();

                    buffer.put(data);

                    buffer.flip();

                    //  ByteBuffer buffer = ByteBuffer.wrap(data);

/*                    ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
                    buffer.put(data);
                    buffer.flip();*/

                    //  Debugger.debug("1");


                    channel.write(buffer, 0, null, new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {

                            // Debugger.debug("over");
                            buffer.clear();
                            bufferPool.offer(buffer);
                            finish.decrementAndGet();
                            if (finish.get() == 0) {
                                System.out.println(stopWatch.getPassedMills());
                            }
                            queue.offer(of);
                            try {
                                channel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            exc.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {

            service.awaitTermination(999, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(stopWatch.getPassedMills());
    }
}
