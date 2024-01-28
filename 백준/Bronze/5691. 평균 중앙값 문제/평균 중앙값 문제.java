import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = nums[0];
            int b = nums[1];

            if (a == 0 && b == 0) break;
            int c = 2 * a - b;
            bw.write(c + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}