import java.util.*;


class Solution {
    int sy, sx;
    
    public boolean move(String[] park, int dir, int cnt) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for (int c = 0; c < cnt; ++c) {
            sy = sy + dy[dir];
            sx = sx + dx[dir];
            if (sy <= -1 || sy >= park.length || sx <= -1 || sx >= park[0].length() 
                || park[sy].charAt(sx) == 'X') return false;
        }
        return true;
    }
    
    public int[] solution(String[] park, String[] routes) {
        
        for (int y = 0; y < park.length; ++y){
            for (int x = 0; x < park[y].length(); ++x){
                if (park[y].charAt(x) == 'S') {
                    sy = y;
                    sx = x;
                }
            }
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('N', 0); map.put('S', 1);
        map.put('W', 2); map.put('E', 3);
        
        for (String route : routes) {
            String[] cmd = route.split(" ");
            int ty = sy;
            int tx = sx;
            
            
            int dir = map.get(cmd[0].charAt(0));
            int cnt = Integer.valueOf(cmd[1]);
            
            if (!move(park, dir, cnt)) {
                sy = ty;
                sx = tx;
            }
        }
        
        int[] answer = {sy, sx};
        return answer;
    }
}