import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public Pair move(String[] board, int y, int x, int dir) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        while (y >= 0 && y < board.length && x >= 0 && x < board[y].length() && board[y].charAt(x) != 'D') {
            y += dy[dir];
            x += dx[dir];
        }
        return new Pair(y - dy[dir], x - dx[dir]);
    }

    public int solve(String[] board, int sy, int sx) {
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[board.length][board[0].length()];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                dist[i][j] = -1;
            }
        }

        q.offer(new Pair(sy, sx));
        dist[sy][sx] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for (int dir = 0; dir < 4; ++dir) {
                Pair next = move(board, y, x, dir);
                int ny = next.y;
                int nx = next.x;
                if (dist[ny][nx] != -1) continue;
                q.offer(next);
                dist[ny][nx] = dist[y][x] + 1;
                if (board[ny].charAt(nx) == 'G') {
                    return dist[ny][nx];
                }
            }
        }
        return -1;
    }

    public int solution(String[] board) {
        int answer = 0;
        int sy = 0, sx = 0;
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[y].length(); ++x) {
                if (board[y].charAt(x) == 'R') {
                    sy = y;
                    sx = x;
                }
            }
        }
        answer = solve(board, sy, sx);
        System.out.println(answer);
        return answer;
    }
}