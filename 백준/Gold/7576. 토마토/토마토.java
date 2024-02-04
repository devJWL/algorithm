import java.util.*;
import java.io.*;




public class Main {

    static int m, n;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int check() {
        int max = 0;
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (map[y][x] == 0) return -1;
                max = Math.max(max, map[y][x]);
            }
        }
        return max > 0 ? max - 1 : 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0];
        n = input[1];
        map = new int[n][m];

        for (int y = 0; y < n; ++y) {
            map[y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int y = 0; y < n; ++y){
            for (int x = 0; x < m; ++x) {
                if (map[y][x] == 1) {
                    q.offer(new int[]{y, x});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];

            for (int dir = 0; dir < 4; ++dir) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == 0) {
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                } else {
                    if (map[ny][nx] > map[y][x] + 1) {
                        map[ny][nx] = map[y][x] + 1;
                        q.offer(new int[]{ny, nx});
                    }
                }

            }
        }

        bw.write(check() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}