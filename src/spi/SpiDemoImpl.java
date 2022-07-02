package spi;

public class SpiDemoImpl implements SpiDemoInterface {

    @Override
    public void say() {
        System.out.println("impl say");
    }
}
