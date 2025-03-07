import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] dist1;
    static int[][] dist2;

    static Queue<int[]> fire = new LinkedList<>();
    static Queue<int[]> jihoon = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = rc[0];
        c = rc[1];
        map = new char[r][c];
        dist1 = new int[r][c];
        dist2 = new int[r][c];

        for (int y = 0; y < r; ++y) {
            Arrays.fill(dist1[y], - 1);
            Arrays.fill(dist2[y], - 1);
        }
        
        for (int y = 0; y < r; ++y) {
            map[y] = br.readLine().toCharArray();
            for (int x = 0; x < c; ++x) {
                if (map[y][x] == 'F') {
                    fire.offer(new int[]{y, x});
                    dist1[y][x] = 0;
                }
                if (map[y][x] == 'J') {
                    jihoon.offer(new int[]{y, x});
                    dist2[y][x] = 0;
                }
            }
        }

        while(!fire.isEmpty()) {
            int[] curr = fire.poll();
            int y = curr[0];
            int x = curr[1];
            
            for (int dir = 0; dir < 4; ++dir) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (dist1[ny][nx] >= 0 || map[ny][nx] == '#') continue;
                dist1[ny][nx] = dist1[y][x] + 1;
                fire.offer(new int[]{ny,nx});
            }
        }

        int time = check();
        
        if (time == -1) {
            bw.write("IMPOSSIBLE\n");
        }
        else {
            bw.write(time + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int check() {
        while(!jihoon.isEmpty()) {
            int[] curr = jihoon.poll();
            int y = curr[0];
            int x = curr[1];
            for (int dir = 0; dir < 4; ++dir) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                    return dist2[y][x] + 1;
                }

                if (dist2[ny][nx] >= 0 || map[ny][nx] == '#') continue;
                if (dist1[ny][nx] != -1 && dist1[ny][nx] <= dist2[y][x] + 1) continue;
                dist2[ny][nx] = dist2[y][x] + 1;
                jihoon.offer(new int[]{ny, nx});
            }
        }
        return -1;
    }
}