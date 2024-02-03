import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n, m;
    static char[][] map;
    static int[][] dist;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Point {
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main() throws IOException {

        String[] token = br.readLine().split(" ");
        n = Integer.valueOf(token[0]);
        m = Integer.valueOf(token[1]);
        map = new char[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; ++i){
            map[i] = br.readLine().toCharArray();
        }

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0));
        dist[0][0] = 1;
        while(!q.isEmpty()){
            Point curr = q.poll();
            if (curr.y == n - 1 && curr.x == m - 1) break;

            for (int dir = 0; dir < 4; ++dir){
                int ny = curr.y + dy[dir];
                int nx = curr.x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == '0') continue;
                if (dist[ny][nx] != 0) continue;
                if (dist[ny][nx] >= dist[curr.y][curr.x] + 1) continue;
                q.add(new Point(ny, nx));
                dist[ny][nx] = dist[curr.y][curr.x] + 1;
            }
        }

        bw.write(dist[n - 1][m - 1] + "");

        br.close();
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        Main.main();        
    }    
}