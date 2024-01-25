import java.util.*;


class Solution {
    // 현재 필요한 물품과 갯수를 가지고 있는 해쉬맵
    Map<String, Integer> map = new HashMap<>();

    public boolean solve(int start, String[] discount) {
        for (int i = start; i < start + 10; ++i) {
            String item = discount[i];
            if (map.containsKey(item)) {
                int cnt = map.get(item) - 1;
                if (cnt == 0 ) {
                    map.remove(item);
                }
                else {
                    map.put(item, cnt);
                }
            }
        }

        return map.size() == 0;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; ++i) {
            for (int j = 0; j < want.length; ++j) {
                map.put(want[j], number[j]);
            }
            if (solve(i, discount)){
                ++answer;
            }
        }
        return answer;
    }
}