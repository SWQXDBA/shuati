package 坑;

public class 多态 {
// 题解 https://www.jianshu.com/p/bbe8377765ea
//静态调度 动态调度
    static class A {
        public String show(D obj){
            return "A and D";
        }
        public String show(A obj){
            return "A and A";
        }
    }
    static class B extends A {
        public String show(B obj){
            return "B and B";
        }
        public String show(A obj){
            return "B and A";
        }
    }
    static class C extends B {
    }
    static class D extends B {
    }
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        System.out.println(a2.show(b));
    }
}
