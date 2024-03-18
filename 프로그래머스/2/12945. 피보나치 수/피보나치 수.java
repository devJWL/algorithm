class Solution {
    public int solution(int n) {
        int answer = 0;
        int first = 0;
        int second = 1;
        final int div = 1234567;

        for (int i = 2; i <= n; ++i){
            answer = (first + second) % div;
            first = second;
            second = answer;
        }
        return answer;
    }
}