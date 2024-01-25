class Solution {
    public long solution(int n) {
        long[] count = new long[2001];
        count[1] = 1;
        count[2] = 2;
        
        for (int i = 3; i <= n; ++i) {
            count[i] = (count[i - 1] % 1234567 + count[i - 2] % 1234567) % 1234567;
        }
        return count[n] % 1234567;
    }
}