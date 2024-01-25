import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] numbers = s.split(" ");
        for (String number : numbers) {
            int value = Integer.valueOf(number);
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        sb.append(min).append(" ").append(max);
        answer = sb.toString();
        return answer;
    }
}