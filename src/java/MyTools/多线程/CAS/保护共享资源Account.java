package MyTools.多线程.CAS;

import java.util.concurrent.atomic.AtomicInteger;


public class 保护共享资源Account {
    public static void main(String[] args) {
        AccountDefault.test();
        AccountSyn.test();
        AccountCAS.test();
    }

    static class AccountCAS {
        AtomicInteger balance;

        public AccountCAS(int balance) {
            this.balance = new AtomicInteger(balance);
        }

        public static void test() {
            AccountCAS accountCAS = new AccountCAS(100000);
            for (int i = 0; i < 10; i++) {
                Thread t1 = new Thread(() -> {

                    for (int j = 0; j < 5000; j++) {
                        accountCAS.withDraw(1);
                    }
                    System.out.println("ok");
                });
                t1.start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(accountCAS.balance);

        }

        public void withDraw(int amount) {
//            while (true) {
//                int prev = balance.get();
//                int res = prev - amount;
//                if (balance.compareAndSet(prev, res)) {
//                    break;
//                }
//                System.out.println("比较失败！！！"+prev+"  "+balance.get());
//            }
            balance.getAndAdd(-amount);
        }
    }

    static class AccountSyn {
        int balance = 0;


        public AccountSyn(int balance) {
            this.balance = balance;
        }

        public static void test() {
            AccountSyn accountSyn = new AccountSyn(100000);
            for (int i = 0; i < 10; i++) {
                Thread t1 = new Thread(() -> {

                    for (int j = 0; j < 5000; j++) {
                        accountSyn.withDraw(1);
                    }
                    System.out.println("ok");
                });
                t1.start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(accountSyn.balance);

        }

        public synchronized void withDraw(int amount) {
            int prev = balance;
            balance = prev - amount;
        }
    }

    static class AccountDefault {
        int balance = 0;

        public AccountDefault(int balance) {
            this.balance = balance;
        }

        public static void test() {
            AccountDefault accountDefault = new AccountDefault(100000);
            for (int i = 0; i < 10; i++) {
                Thread t1 = new Thread(() -> {

                    for (int j = 0; j < 5000; j++) {
                        accountDefault.withDraw(1);
                    }
                    System.out.println("ok");
                });
                t1.start();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(accountDefault.balance);

        }

        public void withDraw(int amount) {
            int prev = balance;
            balance = prev - amount;
        }
    }
}
