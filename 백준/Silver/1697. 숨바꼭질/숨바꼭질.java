import java.util.*;
import java.io.*;




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        dist[n] = 0;

        while(!q.isEmpty()) {
            int curr = q.poll();
            if (curr == k) break;
            for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                if (next < 0 || next >= MAX) continue;
                if (dist[next] != -1) continue;
                dist[next] = dist[curr] + 1;
                q.offer(next);
            }
        }

        bw.write(dist[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}