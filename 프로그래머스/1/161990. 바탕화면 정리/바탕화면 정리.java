class Solution {
    public int[] solution(String[] wallpaper) {
        int len_y = wallpaper.length;
        int len_x = wallpaper[0].length();
        int luy, lux, rdy, rdx;
        
        luy = lux = 55;
        rdy = rdx = -1;
        
        for (int y = 0; y < len_y; ++y) {
            for (int x = 0; x < len_x; ++x) {
                if (wallpaper[y].charAt(x) == '#') {
                    luy = Math.min(luy, y);
                    lux = Math.min(lux, x);
                    rdy = Math.max(rdy, y + 1);
                    rdx = Math.max(rdx, x + 1);
                }
            }
        }
        
        int[] answer = {luy, lux, rdy, rdx};
        return answer;
    }
}