import MyTools.工具类.RandomTool;

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

        String[]teachers  = new String[]{"林亚明","柯财富","余兆钗"};
        long randomABS = RandomTool.getRandomABS(2);
        System.out.println(teachers[(int) randomABS]);

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

