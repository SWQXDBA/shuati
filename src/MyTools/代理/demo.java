package MyTools.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class demo {

    public static void main(String[] args) {
        //接口的实现类
        Animal bird = () -> System.out.println("鸟在吃");

        //处理器 在其中调用接口的方法 以及进行其他代理操作
        //这里实现的是invoke方法
        InvocationHandler handler = (proxy, method, argss) -> {
            System.out.println("处理器1执行插入的代码");
            Object result = method.invoke(bird, argss);
            System.out.println("处理器1执行插入的代码2");
            return result;
        };
        InvocationHandler handler2 = (proxy, method, argss) -> {
            System.out.println("处理器2执行插入的代码");
            Object result = method.invoke(bird, argss);
            System.out.println("处理器2执行插入的代码2");
            return result;
        };
        //生成代理对象
        //(类加载器，接口，处理器)

        //因此 通过不同的处理器 可以获得不同的代理对象
        Animal ProxyBird = (Animal) Proxy.newProxyInstance(demo.class.getClassLoader(), bird.getClass().getInterfaces(), handler);
        ProxyBird.eat();//生成的代理对象拥有这个接口的方法 但是执行这个方法的时候实际上执行处理器的invoke方法: ProxyBird.eat()相当于handler.invoke()
        ProxyBird = (Animal) Proxy.newProxyInstance(demo.class.getClassLoader(), bird.getClass().getInterfaces(), handler2);
        ProxyBird.eat();

    }


    public interface Animal {
        void eat();
    }
}
