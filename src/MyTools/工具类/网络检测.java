package MyTools.工具类;

import java.io.File;
import java.util.Random;

public class 网络检测 {
    public static void main(String[] args) {
        var array = new double[8][6];
        Random random = new Random();
        for (var arr : array) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextDouble();
            }
        }

        for (var arr : array) {
            var sum = 0d;
            for (var d : arr) {
                sum += d;
                System.out.print(d + " ");
            }
            System.out.println("总和:" + sum);
        }
    }

    public static void copy(File source, File dest) {


    }
}
