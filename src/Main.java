/**
 * @author SWQXDBA
 */
public class Main {

    public static void main(String[] args) {
        Father father = new Father();


    }

    static class Father {
        String name = getName(getName(null));


        public Father() {
            System.out.println("const");
        }

        private String getName(Object o) {
            System.out.println("getName" + name);
            return "555";
        }

    }
}

