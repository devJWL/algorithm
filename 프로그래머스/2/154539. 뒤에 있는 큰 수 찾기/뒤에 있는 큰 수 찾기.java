import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        // 아직 처리되지 않은 인덱스를 가지고 있는 스택
        Stack<Integer> stack = new Stack<>();
        
        for (int idx = 0; idx < numbers.length; ++idx) {
            while(!stack.isEmpty() && numbers[idx] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[idx];
            }
            stack.push(idx);
        }
        return answer;
    }
}