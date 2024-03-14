import java.util.*;

class Solution {
    public long solution(int[] weights) {
        
        long answer = 0;
        
        Map<Integer, Long> cnt = new HashMap();
        for (int weight : weights){
            cnt.put(weight, cnt.getOrDefault(weight, 0L) + 1);
        }

        for (int weight : cnt.keySet()){
            long n = cnt.get(weight);
            if (n > 1) answer += (n - 1) * n / 2;
            if (weight % 2 == 0) answer += n * cnt.getOrDefault(weight / 2 * 3, 0L);
            if (weight % 3 == 0) answer += n * cnt.getOrDefault(weight / 3 * 4, 0L);
            
            answer += n * cnt.getOrDefault(weight * 2, 0L);
        }
        
        return answer;
    }
}