class A {

}

class B extends A {

}

class C extends A {

}

class D extends B {


}

public class Main {

    public static void fun(A a) {
        System.out.println("A");
    }

    public static void fun(B a) {
        System.out.println("B");
    }

    public static void fun(C a) {
        System.out.println("C");
    }


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        A a3 = new C();
        A a4 = new D();
        fun(a1);
        fun(a2);
        fun(a3);
        fun(a4);
        fun(new D());
    }

}

