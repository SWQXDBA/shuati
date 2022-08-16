/**
 * @author SWQXDBA
 */

public class Main {
    static Thread test() {
        Execut execut1 = new Execut();
        final Execut execut = new Execut();
        return new Thread(execut::fun);
    }

    public static void main(String[] args) {
        final Thread test = test();
        System.gc();
        test.start();
    }

    static class Execut {
        public void fun() {
            System.out.println(this.hashCode());
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

}

