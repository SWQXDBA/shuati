public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            int k;
            for (k = 1; k < i; k++) {
                System.out.print("  ");
            }
            for (int j = k; j <= 9; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}