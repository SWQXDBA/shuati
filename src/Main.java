import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Main {
    public static void main(String[] args) {
        Person p = new Person();
        Class<Person> c = Person.class;
        try {
            Method method = c.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);
            Method method1 = c.getDeclaredMethod("setAge", int.class);

            try {
                method.invoke(p, "你的名字");
                method1.setAccessible(false);
                method1.invoke(p, 15);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        private void setName(String name) {
            System.out.println("name setted");
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            System.out.println("给了年龄");
            this.age = age;
        }
    }

    class Son extends Person {
        public Son() {
            System.out.println();

        }
    }

}



