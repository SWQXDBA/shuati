package MyTools.我的数据结构;

public class TestObj {
    String name;
    int age;

    public TestObj(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 1;
        // return age+name.hashCode();
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        TestObj t = (TestObj) obj;
        return t.name.equals(name) && t.age == age;
    }
}
