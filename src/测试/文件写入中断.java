package 测试;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class 文件写入中断 {
    public static void main(String[] args) {
        new Simple<String>() {
        }.get();
        new Simple<String>().get();//ClassCastException
    }

    static class Simple<T> {

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public void get() {
            final Type actualTypeArgument = ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            System.out.println(actualTypeArgument);
        }
    }
}
