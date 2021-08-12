import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("11", 5);
                put("abc", 6);
                System.out.println(this.getClass().getSuperclass());
            }
        };


    }
}
