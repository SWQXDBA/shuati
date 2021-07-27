package MyTools.我的数据结构.twst;

public class Son extends Father {
    int sonAge;

    public Son(String fatherName, int sonAge) {

        this.sonAge = sonAge;
    }

    public static void main(String[] args) {
        Son s = new Son("father", 15);
        System.out.println(s);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
