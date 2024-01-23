import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int bit = 1;
        int count = 0;


        for (int i = 0; i < 31; ++i) {
            if ((n & bit) != 0) {
                ++count;
            }
            bit = bit << 1;
        }

        int answer = count == 1 ? 1 : 0;

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}