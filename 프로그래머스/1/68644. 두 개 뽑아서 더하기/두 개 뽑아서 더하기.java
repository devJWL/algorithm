import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; ++i) {
        	for (int j = i + 1; j < numbers.length; ++j) {
        		int sum = numbers[i] + numbers[j];
        		set.add(sum);
        	}
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
