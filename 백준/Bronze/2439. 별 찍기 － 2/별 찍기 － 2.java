import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {


        int n = Integer.valueOf(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }

        for (int i = 0; i < n; ++i) {
            sb.deleteCharAt(0);
            sb.append('*');
            bw.write(sb.toString() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
