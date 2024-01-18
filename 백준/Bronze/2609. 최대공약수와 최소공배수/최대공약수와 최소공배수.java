import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int GCD(int a, int b) {
        int r = a % b;
        if (r == 0){
            return b;
        }
        return GCD(b, r);
    }
    public static void main(String[] args) throws IOException {

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int gcd = GCD(nums[0], nums[1]);
        int lcm = nums[0] / gcd * nums[1];

        bw.write(gcd + "\n" + lcm);
        br.close();
        bw.flush();
        bw.close();
    }
}
