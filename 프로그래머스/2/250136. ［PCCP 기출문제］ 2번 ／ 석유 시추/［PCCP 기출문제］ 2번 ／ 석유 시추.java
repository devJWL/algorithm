import java.util.*;


class Point {
    int y, x;
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}


class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[] answers = new int[m];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visit = new boolean[n][m];
        
        
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (land[y][x] == 0) continue;
                if (visit[y][x]) continue;
                
                int cnt = 0;
                boolean[] check = new boolean[m];
                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(y , x));
                visit[y][x] = true;
                check[x] = true;
                ++cnt;

                while(!q.isEmpty()) {
                    Point p = q.poll();
                    for (int dir = 0; dir < 4; ++dir) {
                        int ny = p.y + dy[dir];
                        int nx = p.x + dx[dir];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if (land[ny][nx] == 0) continue;
                        if (visit[ny][nx]) continue;
                        q.offer(new Point(ny, nx));
                        visit[ny][nx] = true;
                        check[nx] = true;
                        ++cnt;
                    }
                }
                
                for (int i = 0; i < check.length; ++i) {
                    if (check[i]) {
                        answers[i] += cnt;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; ++i) {
            answer = Math.max(answer, answers[i]);
        }
        
        return answer;
    }
}