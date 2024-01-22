import java.util.*;


class Solution {
    public int solution(String s) {
        
        int answer = 0;
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> map = new HashMap<>();
        StringBuilder number = new StringBuilder(); 
        
        for (int i = 0; i < 10; ++i) {
            map.put(numbers[i], i);
        }
        
        for (int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9'){
                answer = answer * 10 + Integer.valueOf(ch - '0');
            }
            else {
                number.append(ch);
                if (map.containsKey(number.toString())) {
                    answer = answer * 10 + map.get(number.toString());
                    number.delete(0, number.length());
                }
            }
        }
        return answer;
    }
}
