import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        // DP[i] = i번 인덱스에서 시작한 누적합
        // DP[i][j] i번 인덱스에서 시작해서 길이가 j인 경우까지의 누적합으로 생각하면 더 편함
        int[] DP = new int[elements.length];

        for(int len = 1; len <= elements.length; ++len) {
            for(int i = 0; i < elements.length; ++i) {
                DP[i] += elements[(len + i - 1) % elements.length];
                set.add(DP[i]);
            }
        }
        return set.size();
    }
}