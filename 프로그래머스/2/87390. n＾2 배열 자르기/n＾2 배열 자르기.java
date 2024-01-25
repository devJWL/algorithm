import java.util.*;


class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (long i = left; i <= right; ++i){
            int r = (int)(i / n);
            int c = (int)(i % n);

            if (r <= c){
                list.add(c + 1);
            }
            else {
                list.add(r + 1);
            }
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
