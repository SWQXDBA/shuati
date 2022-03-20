package MyTools.工具类;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

// https://stackoverflow.com/questions/47177/how-do-i-monitor-the-computers-cpu-memory-and-disk-usage-in-java
public class 系统检测 {
    public static void main(String[] args) {
        OperatingSystemMXBean mxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        while (true) {
            Sleeper.sleep(500L);
            StringBuilder stringBuilder = new StringBuilder("\r");
            stringBuilder.append("空闲内存:").append(String.format("%.2f", mxBean.getFreeMemorySize() / 1024.0 / 1024 / 1024)).append("gb ");
            stringBuilder.append("cpu占用:").append(String.format("%.2f", mxBean.getCpuLoad()));
            System.out.print(stringBuilder.toString());
        }

    }
}
