import java.util.*;


class Point {
    int y, x;
    Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}


class Solution {
    int n, m;
    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};
    boolean[][] visit;
    
    public int bfs(int y, int x, String[] maps) {
        int days = (maps[y].charAt(x) - '0');
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visit[y][x] = true;
        while(!q.isEmpty()) {
            Point curr = q.poll();
            for (int dir = 0; dir < 4; ++dir) {
                int ny = curr.y + dy[dir];
                int nx = curr.x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (maps[ny].charAt(nx) == 'X') continue;
                if (visit[ny][nx]) continue;
                q.add(new Point(ny, nx));
                visit[ny][nx] = true;
                days += (maps[ny].charAt(nx) - '0');
            }
        }
        return days;
    }
    
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        int[] answer;
        
        for (int y = 0; y < n; ++y){
            for (int x = 0; x < m; ++x) {
                if (visit[y][x]) continue;
                if (maps[y].charAt(x) == 'X') continue;
                list.add(bfs(y, x, maps));
            }
        }
        
        if (list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[list.size()];
            Collections.sort(list);
            for (int i = 0; i < list.size(); ++i) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}