import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int exp = (int)Math.log10(n);
        int len = 1;
        int answer = 0;
        int count = 9;

        for (int i = 0; i < exp; ++i) {
            answer += len * count;
            ++len;
            count *= 10;
        }

        answer += (n - (int)Math.pow(10, exp) + 1) * len;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}