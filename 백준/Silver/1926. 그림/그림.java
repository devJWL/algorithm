import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];


        for (int i = 0; i < n; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        int max_size = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (map[y][x] == 0) continue;
                if (visited[y][x]) continue;
                ++count;
                int size = 0;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{y, x});
                visited[y][x] = true;
                ++size;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; ++dir) {
                        int ny = cur[0] + dy[dir];
                        int nx = cur[1] + dx[dir];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if (map[ny][nx] == 0) continue;
                        if (visited[ny][nx]) continue;
                        visited[ny][nx] = true;
                        ++size;
                        q.add(new int[]{ny, nx});
                    }
                }
                if (max_size < size) max_size = size;
            }
        }

        bw.write(count + "\n");
        bw.write( max_size + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}