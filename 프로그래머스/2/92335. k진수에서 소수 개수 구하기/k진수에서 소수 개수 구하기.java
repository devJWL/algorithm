import java.util.*;


class Solution {
    boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i * i <= number; ++i) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        sb.reverse();
        String[] token = sb.toString().split("0");
        
        for (int i = 0; i < token.length; ++i) {
            if (token[i].length() == 0) continue;
            long number = Long.parseLong(token[i]);
            if (isPrime(number)) ++answer;
        }
        return answer;
    }
}