class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        String color = board[h][w];
        boolean[][] check = new boolean[n][n];
        
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        
        check[h][w] = true;
        for (int dir = 0; dir < 4; ++dir) {
            int nh = h + dh[dir];
            int nw = w + dw[dir];
            if (nh < 0 || nh >= n || nw < 0 || nw >= n) continue;
            if (check[nh][nw]) continue;
            check[nh][nw] = true;
            if (board[nh][nw].equals(color)) {
                ++count;
            }
        }
        return count;
    }
}