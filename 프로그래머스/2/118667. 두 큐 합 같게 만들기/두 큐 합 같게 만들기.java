import java.util.*;


class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long target = 0;
        for (int num : queue1) {
            sum += num;
            q1.offer(num);
            target += num;
        }
        for (int num : queue2) {
            sum += num;
            q2.offer(num);
        }
        
        long goal = sum / 2;
        
        while(true) {
            if (answer > (queue1.length + queue2.length) * 2) return -1;
            if (target == goal) break;
            else if(target > goal) {
                target -= q1.peek();
                q2.add(q1.poll()); 
            }else {                 
                target += q2.peek();
                q1.add(q2.poll());
            }
            ++answer;
        }
        return answer;
    }
}