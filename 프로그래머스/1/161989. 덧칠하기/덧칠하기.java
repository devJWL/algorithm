class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;
        for (int s : section) {
            if (max < s) {
                ++answer;
                max = s + m - 1;
            }
        }
        return answer;
    }
}