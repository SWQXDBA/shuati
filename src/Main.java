/**
 * @author SWQXDBA
 */
public class Main {
    public static class Fa {
        public Fa() {
            say();
            this.say();
        }

        public void say() {
            System.out.println("im father");
        }
    }

    public static class Son extends Fa {
        public Son() {
            super();
            say();
            this.say();
        }

        @Override
        public void say() {
            super.say();
            System.out.println("im son");
        }
    }

    public static void main(String[] args) {

    }


}

