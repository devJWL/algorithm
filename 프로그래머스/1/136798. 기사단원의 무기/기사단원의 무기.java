class Solution {
    int solve(int number) {
        int count = 0;
        
        for (int i = 1; i * i <= number; ++i) {
            if (number % i == 0) {
                if (i * i == number) count += 1;
                else count += 2;
            }
        }
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        while(number > 0) {
            int res = solve(number);
            if (res <= limit) answer += res;
            else answer += power;
            --number;
        }
        return answer;
    }
}