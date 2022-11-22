package spi;

import java.util.ServiceLoader;

public class SpiTest {
    public static void main(String[] args) {
        final ServiceLoader<SpiDemoInterface> interfaces = ServiceLoader.load(SpiDemoInterface.class);
        for (SpiDemoInterface anInterface : interfaces) {
            anInterface.say();
        }
    }
}
