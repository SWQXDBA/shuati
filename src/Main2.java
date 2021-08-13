public class Main2 {
    static void dosT(Animal animal) {
        if (animal instanceof bird) {
            ((bird) animal).fly();
        }
        if (animal instanceof pig)
            ((pig) animal).run();
    }

    public static void main(String[] args) {
        Animal a1 = new bird();
        Animal a2 = new pig();
        dosT(a1);
        dosT(a2);


    }

    static class Animal {

    }

    static class bird extends Animal {
        public void fly() {
            System.out.println("fly");
        }
    }

    static class pig extends Animal {
        public void run() {
            System.out.println("run");
        }
    }
}
