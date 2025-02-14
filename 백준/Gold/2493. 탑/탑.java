import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<int[]> st = new Stack<>();
        st.push(new int[]{Integer.MAX_VALUE, 0});

        for (int i = 0; i < n; ++i) {
            while(st.peek()[0] <= towers[i]) {
                st.pop();
            }
            bw.write(st.peek()[1] + " ");
            st.push(new int[]{towers[i], i + 1});
        }

        bw.flush();
        bw.close();
        br.close();
    }
}