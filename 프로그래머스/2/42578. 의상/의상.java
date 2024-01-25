import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
        	String type = clothes[i][1];
        	map.put(type, map.getOrDefault(type, 1) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        
        for (int e : list) {
        	answer *= e;
        }
        return answer - 1;
    }
}