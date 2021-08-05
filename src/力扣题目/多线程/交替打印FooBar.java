package 力扣题目.多线程;

public class 交替打印FooBar {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(100);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("FOO");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("BAR");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.start();
        t1.join();
    }

    static class FooBar {
        volatile Boolean flag = true;//true==foo false==bar
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (!flag) {
                        wait();
                    }
                    // printFoo() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = false;
                    notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag) {
                        wait();
                    }
                    // printBar() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = true;
                    notifyAll();
                }
            }
        }
    }


}
