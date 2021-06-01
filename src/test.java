public class test {
    public static void main(String[] args) {
        A<String> a = new A<>("aaa");
        System.out.println(a.get());


    }

    static class A<T> {
        T value;

        A(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

}


