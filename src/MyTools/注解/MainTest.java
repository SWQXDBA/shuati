package MyTools.注解;

@MyAnnotation("123")
public class MainTest {
    public static void main(String[] args) {
        MainTest test = new MainTest();
        MyAnnotation annotation = test.getClass().getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
        MyAnnotation2 annotation2 = annotation.annotationType().getDeclaredAnnotation((MyAnnotation2.class));
        System.out.println(annotation2.val());

        System.out.println(annotation.getClass()); //这个获得的是一个代理对象
        System.out.println(MyAnnotation.class);
        //不相等
        System.out.println(MyAnnotation.class == annotation.getClass());
        //相等
        System.out.println(MyAnnotation.class == annotation.annotationType());

    }
}
