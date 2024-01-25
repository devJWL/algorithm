class Solution {
    boolean[] used;
    int answer = 0;
    void BT(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; ++i) {
            if (used[i]) continue;
            if (dungeons[i][0] > k) continue;
            used[i] = true;
            BT(k - dungeons[i][1], dungeons, cnt + 1);
            used[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
    
    public int solution(int k, int[][] dungeons) {
        used = new boolean[dungeons.length];
        BT(k, dungeons, 0);
        return answer;
    }
}