import MyTools.工具类.Debugger;
import MyTools.工具类.UnsafeGetter;
import sun.misc.Unsafe;

public class Main2 {

    public static void main(String[] args) {
        Unsafe unsafe = UnsafeGetter.get();
        Debugger.debug(unsafe == UnsafeGetter.get());

    }
}
