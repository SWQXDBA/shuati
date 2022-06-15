package MyTools.ThreadLocal;

//总结
//让threadLocal = null 或者回收持有 threadLocal的对象时 为了使得 threadLocal被正确回收 需要使用弱引用
//为了保证value及时回收 需要调用remove方法 否则线程存在的时候还会在TheadLocalMap的Entry中持有这个value
// 除非 调用了其他threadLocal的 set/remove等发方法来触发cleanSomeSlots
//总结： 通过弱引用保证key被及时回收（key就是ThreadLocal对象） 通过remove()保证value及时回收
public class 虚引用Demo {

    public static void main(String[] args) {
        {
            Task task = new Task();
            task.run();
            task = null;
            final Thread thread = Thread.currentThread();
            System.out.println("在此处打断点查看threadLocalMap 此时应该还存着 userThreadLocal");
            System.gc();
            System.out.println("在此处打断点查看threadLocalMap 此时 \"username\" 应该已经被回收,但是User 本身还存在");
            System.out.println(thread);
        }


        {
            Task task = new Task();
            task.run2();
            task = null;
            final Thread thread = Thread.currentThread();
            System.out.println("在此处打断点查看threadLocalMap 此时应该还存着 userThreadLocal");
            System.gc();
            ThreadLocal local = new ThreadLocal();
            //调用cleanSomeSlots
            local.remove();

            System.out.println("在此处打断点查看threadLocalMap 此时 \"username\" 应该已经被回收,并且User 应该也被回收了");
            System.out.println(thread);
        }


    }

    static class User {

    }

    static class Task {
        ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

        public void run() {

            userThreadLocal.set(new User());
            userThreadLocal.get();


            // 方法退出 Task对象被销毁如果此时不是虚引用 那么这个Thread还会保存一份对userThreadLocal的引用 导致userThreadLocal无法被释放

        }

        public void run2() {

            userThreadLocal.set(new User());
            userThreadLocal.get();
            //此时使用结束 我们要释放这个变量
            userThreadLocal.remove();
            // 方法退出 Task对象被销毁如果此时不是虚引用 那么这个Thread还会保存一份对userThreadLocal的引用 导致userThreadLocal无法被释放

        }

    }
}
