import java.util.*;


class Solution {
    public int[] solution(String s) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < s.length(); ++i) {
            if (alphabet[(int) (s.charAt(i) - 'a')] == -1) {
                list.add(-1);
            } else {
                list.add(i - alphabet[(int) (s.charAt(i) - 'a')]);
            }
            alphabet[(int) (s.charAt(i) - 'a')] = i;
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}