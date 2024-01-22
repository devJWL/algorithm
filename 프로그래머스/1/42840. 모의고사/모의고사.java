import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
    	int[] stu1 = new int[] { 1, 2, 3, 4, 5 };
    	int[] stu2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
    	int[] stu3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    	
    	int[] counts = { 0, 0, 0, 0 };
    	for (int i = 0; i < answers.length; ++i) {
    		if (stu1[i % stu1.length] == answers[i]) {
    			counts[1]++;
    		}
    		if (stu2[i % stu2.length] == answers[i]) {
    			counts[2]++;
    		}
    		if (stu3[i % stu3.length] == answers[i]) {
    			counts[3]++;
    		}
    	}
    	
    	int max = 0;
    	for (int i = 1; i <= 3; ++i) {
    		if (counts[i] > max)
    			max = counts[i];
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	for (int i = 1; i <= 3; ++i) {
    		if (counts[i] == max) {
    			list.add(i);
    		}
    	}
        
    	int[] answer = new int[list.size()];
    	for (int i = 0; i < list.size(); ++i) {
    		answer[i] = list.get(i);
    	}
        
        return answer;
    }
}