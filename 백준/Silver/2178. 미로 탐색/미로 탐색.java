import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        char[][] map = new char[n][m];

        for (int i = 0; i < n; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] dist = new int[n][m];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            if (y == n - 1 && x == m - 1) break;

            for (int dir = 0; dir < 4; ++dir) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == '0') continue;
                if (dist[ny][nx] >= dist[y][x] + 1) continue;
                q.add(new int[]{ny, nx});
                dist[ny][nx] = dist[y][x] + 1;
            }
        }

        bw.write(dist[n - 1][m - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}