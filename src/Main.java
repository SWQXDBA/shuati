import java.math.BigInteger;
import java.util.Random;

/**
 * @author SWQXDBA
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            s.append(random.nextInt(9));
        }
        BigInteger bigInteger = new BigInteger(s.toString());
        System.out.println(bigInteger.subtract(BigInteger.ONE));

        final String string = bigInteger.toString();
        System.out.println(string.substring(0, string.length() / 2));
    }


}

