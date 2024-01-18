import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(br.readLine());
        int factorial = 1;
        for (int i = 2; i <= n; ++i) {
            factorial *= i;
        }
        bw.write(factorial + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
