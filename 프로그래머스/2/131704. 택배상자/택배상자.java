import java.util.Stack;

class Solution {
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> temp = new Stack<>();

        int idx = 0;

        for (int curr = 1; curr <= order.length; ++curr) {
            boolean flag = true;
            //1. 꺼낸 택배상자가 순서에 맞을 때
            if (curr == order[idx]) {
                idx++;
                answer++;
                flag = false;
            }
            
            
            //2. 꺼낸 택배상자가 순서에 맞지 않지만, 보조 컨테이너에서 꺼낸 택배가 순서에 맞을 때
            while (!temp.isEmpty() && temp.peek() == order[idx]) {
                temp.pop();
                idx++;
                answer++;
                flag = false;
            }
            // 3. 보조 컨테이너에 넣는다
            if (flag) {
                temp.push(curr);
            }
        }

        //4. 남은 상자들을 보조 컨테이너에서 빼준다
        while (!temp.isEmpty() && temp.peek() == order[idx]) {
            temp.pop();
            idx++;
            answer++;
        }

        return answer;
    }
}