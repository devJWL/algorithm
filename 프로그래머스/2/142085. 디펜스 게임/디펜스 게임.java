import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
       int answer = 0;

        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        while (idx < enemy.length) {
            if (n < enemy[idx] && k <= 0) break;
            n -= enemy[idx];
            pq.add(enemy[idx]);

            if (n < 0) {
                n += pq.poll();
                k--;
            }

            idx++;
        }
        answer = idx;

        return answer;
    }
}