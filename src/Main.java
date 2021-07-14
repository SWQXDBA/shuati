import java.io.*;

class Main {
    static void printf(String format, Object... args) {
        PrintStream p = System.out.printf(format, args);

    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            //      System.out.println("您输入了"+input);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.write("您输入了" + input);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}



