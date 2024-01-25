class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        
        for (int lotto : lottos){
            if (lotto == 0) {
                ++zero;
                continue;
            }
            for (int num : win_nums){
                if (lotto == num) ++cnt;
            }
        }
        
        answer[0] = zero + cnt > 1 ? 7 - (zero + cnt) : 6;
        answer[1] = cnt > 1 ? 7 - cnt : 6;
        
        return answer;
    }
}