import java.util.*;


class Solution {
    Map<Character, Integer> map;
    
    int solve(String target) {
        int cnt = 0;
        for (char ch : target.toCharArray()) {
            if (!map.containsKey(ch)) return -1;
            cnt += map.get(ch);
        }
        return cnt;
    }
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        final int MAX = 100;
        
        map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); ++i){
                char ch = key.charAt(i);
                if (map.getOrDefault(ch, MAX + 1) > i + 1)
                    map.put(key.charAt(i), i + 1);
            }
        }
        
        for (int i = 0; i < targets.length; ++i) {
            answer[i] = solve(targets[i]);
        }
        
        return answer;
    }
}