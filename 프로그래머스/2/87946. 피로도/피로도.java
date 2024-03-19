class Solution {
    boolean[] visited;
    int[][] dun;
    int answer = 0;
    
    void BT(int k, int cnt) {
        for (int i = 0; i < dun.length; ++i) {
            if (visited[i]) continue;
            if (dun[i][0] > k) continue;
            visited[i] = true;
            BT(k - dun[i][1], cnt + 1);
            visited[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dun = dungeons;
        BT(k, 0);
        return answer;
    }
}