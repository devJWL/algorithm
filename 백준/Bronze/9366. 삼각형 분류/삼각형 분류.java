import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String type = "";

        for (int i = 1; i <= t; ++i) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];

            if (a + b <= c) {
                type = "invalid!";
            } else {
                if (a == b && b == c) {
                    type = "equilateral";
                }
                else if (a == b || b == c || c == a) {
                    type = "isosceles";
                }
                else {
                    type = "scalene";
                }
            }

            bw.write(String.format("Case #%d: %s\n", i, type));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}