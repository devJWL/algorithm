import java.util.Arrays;


public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                answer = n - i;
                break;
            }
        }
        return answer;
    }
}