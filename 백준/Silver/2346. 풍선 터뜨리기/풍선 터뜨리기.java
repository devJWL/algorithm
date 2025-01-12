import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums.length; ++i) {
            deque.offer(new int[]{i + 1, nums[i]});
        }

        while(!deque.isEmpty()) {
            int[] pair = deque.pollFirst();
            int pos = pair[0];
            int iter = pair[1];

            bw.write(pos + " ");

            if(deque.isEmpty()) break;

            if (iter > 0) {
                while(--iter > 0) {
                    deque.offerLast(deque.pollFirst());
                }

            } else {
                while(iter++ < 0) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
