import java.util.*;
import java.io.*;




public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] nums = new int[10];
    static boolean[] used = new boolean[10];

    static void BT(int curr) throws IOException {
        if (curr == m) {
            for (int i = 0; i < m; ++i){
                bw.write(nums[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; ++i){
            nums[curr] = i;
            BT(curr + 1);
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