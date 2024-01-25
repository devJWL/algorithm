import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> chulsu = new HashSet<>();
        Map<Integer, Integer> bro = new HashMap<>();
        // 우선 동생이 모든 케이크를 먹는다고 가정
        for (int t : topping) {
            bro.put(t, bro.getOrDefault(t, 0) + 1);
        }
        // 철수가 한 칸씩 차지하면서 종류의 수가 같은지 확인
        for (int t : topping) {
            chulsu.add(t);
            int cnt = bro.getOrDefault(t, -1);
            // 해당 토핑을 동생이 가지고 있는 경우
            if (cnt != -1) {
                --cnt;
                if (cnt == 0) {
                    bro.remove(t);
                }
                else {
                    bro.put(t, cnt);
                }
            }
            if (chulsu.size() == bro.size()) {
                ++answer;
            }
        }
        return answer;
    }
}