import java.lang.reflect.Method;

class Main {
    public static void main(String[] args) {
        Class<Integer> t = Integer.class;
        Method[] methods = t.getMethods();
        System.out.println(methods.length);
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println(t.getSuperclass());
    }

}



