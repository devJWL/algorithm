import java.util.Stack;


class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        // 비어있는 스택을 방지하기 위해서
        stack.push(-1);
        for (int ing : ingredient) {
            if (stack.peek() == 1 && ing == 2) {
                stack.pop();
                stack.push(12);
            }
            else if (stack.peek() == 12 && ing == 3){
                stack.pop();
                stack.push(123);
            }
            else if (stack.peek() == 123 && ing == 1) {
                stack.pop();
                ++answer;
            }
            else {
                stack.push(ing);
            }
        }
        
        return answer;
    }
}