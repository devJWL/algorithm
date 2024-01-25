class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n + 2];
        
        for (int c : lost) {
            --count[c];
        }
        for (int c : reserve) {
            ++count[c];
        }
        
        for (int i = 1; i <= n; ++i) {
            if (count[i] >= 0) continue;
            if (count[i - 1] == 1){
                --count[i - 1];
                ++count[i];
            }
            else if (count[i + 1] == 1){
                --count[i + 1];
                ++count[i];
            }
        }
        
        for (int i = 1; i <= n; ++i) {
            if (count[i] >= 0) ++answer;
        }
        return answer;
    }
}