public class Solution {
    public static long solution(long n) {
        long answer = 0;
        int[] cnt = new int[10];
        
        while (n != 0) {
            cnt[(int)(n % 10)]++;
            n /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            while (cnt[i] != 0) {
                answer = answer * 10 + i;
                cnt[i]--;
            }
        }
        return answer;
    }
}