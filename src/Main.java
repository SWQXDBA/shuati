import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(3000);


        Predicate<Integer> p = Predicate.not((integer -> !Objects.equals(integer, 3000)));
        list.removeIf(p);
        System.out.println(list);

    }


}

