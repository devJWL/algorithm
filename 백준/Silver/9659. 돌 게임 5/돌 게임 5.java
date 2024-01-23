import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        n %= 4L;

        if (n == 0L || n == 2L) {
            bw.write("CY\n");

        }
        else {
            bw.write("SK\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}