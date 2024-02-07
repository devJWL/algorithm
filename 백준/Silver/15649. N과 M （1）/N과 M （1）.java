import java.util.*;
import java.io.*;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] nums = new int[10];
    static boolean[] used = new boolean[10];

    static void BT(int d) throws IOException {
        if (d == m) {
            for (int i = 0; i < d; ++i){
                bw.write(nums[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = 1; i <= n; ++i) {
            if (used[i]) continue;
            nums[d] = i;
            used[i] = true;
            BT(d + 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {



        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        BT(0);

        bw.flush();
        bw.close();
        br.close();
    }
}