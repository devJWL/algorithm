import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
        	map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        while(count < k) {
        	count += list.get(answer);
        	++answer;
        }
        return answer;
    }
}