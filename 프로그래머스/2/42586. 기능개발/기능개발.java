import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		int day = 1;
		int index = 0;
		while(index < progresses.length) {
			int count = 0;
			while(index < progresses.length && (progresses[index] + speeds[index] * day) >= 100) {
				++count;
				++index;
			}
			
			if (count > 0) {
				list.add(count);
			}
			++day;
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = list.get(i);
		}
        
		return answer;
	}
}