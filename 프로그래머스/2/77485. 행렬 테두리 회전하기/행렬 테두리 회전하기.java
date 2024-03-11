import java.util.*;


class Solution {

    int[][] map;
    List<Integer> result = new ArrayList<>();
    
    void rotate(int x1, int y1, int x2, int y2) {
        int start = map[x1][y2];
        int min = start;
        
        // 오른쪽으로 밀기 - 상단
        for (int y = y2 - 1; y >= y1; --y) {
            min = Math.min(min, map[x1][y]);
            map[x1][y + 1] = map[x1][y];
        }
        
        // 위로 밀기 - 좌측
        for (int x = x1 + 1; x <= x2; ++x) {
            min = Math.min(min, map[x][y1]);
            map[x - 1][y1] = map[x][y1];
        }
        
        // 왼쪽으로 밀기 - 하단
        for (int y = y1 + 1; y <= y2; ++y) {
            min = Math.min(min, map[x2][y]);
            map[x2][y - 1] = map[x2][y];
        }
        
        // 아래로 밀기 - 우측
        for (int x = x2 - 1; x >= x1; --x) {
            min = Math.min(min, map[x][y2]);
            map[x + 1][y2] = map[x][y2];
        }

        map[x1 + 1][y2] = start;
        result.add(min);
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        for (int i = 0; i < rows; ++i)  {
            for (int j = 0; j < columns; ++j) {
                map[i][j] = columns * i + j + 1;
            }
        }
        
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            rotate(x1, y1, x2, y2);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}