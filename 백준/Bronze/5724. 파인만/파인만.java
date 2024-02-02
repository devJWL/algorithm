import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int answer = n * (n + 1) * (2 * n + 1) / 6;
            bw.write(answer + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}