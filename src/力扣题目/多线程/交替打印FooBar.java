package 力扣题目.多线程;

public class 交替打印FooBar {
    static class FooBar {
        boolean flag = false;
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                if (!flag) {
                    printFoo.run();
                    flag = true;
                } else {
                    i--;
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                if (flag) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printBar.run();
                    flag = false;
                } else {
                    i--;
                }
            }
        }
    }

}
