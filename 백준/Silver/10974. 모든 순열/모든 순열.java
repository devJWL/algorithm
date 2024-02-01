import java.util.*;
import java.io.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[] used;
    static int[] nums;

    static void dfs(int d) throws IOException {
        if (d == n) {
            for (int i = 0; i < n; ++i) {
                bw.write(nums[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (used[i]) continue;
            nums[d] = i;
            used[i] = true;
            dfs(d + 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        used = new boolean[n + 1];
        nums = new int[n];

        dfs(0);

        bw.flush();
        bw.close();
        br.close();
    }
}