import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static void MyFunction(myi i) {
        System.out.println(i);
        System.out.println(i.f(15));
    }

    public static void main(String[] args) {
        Comparator.comparingDouble(Emo::getTime);
        MyFunction(new myi() {
            @Override
            public int f(int p) {
                return p * 10;
            }
        });
        MyFunction(Emo::getTime);
        ArrayList
    }

    interface myi {
        int f(int p);
    }

    static class Emo {
        int time;

        public static int getTime(int i) {
            return i * 10;
        }

        void te() {

        }
    }
}

