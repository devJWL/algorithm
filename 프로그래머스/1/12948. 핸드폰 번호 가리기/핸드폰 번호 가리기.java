import java.util.Arrays;

class Solution {
    public String solution(String phone_number) {
        char[] stars = new char[phone_number.length() - 4];
        Arrays.fill(stars, '*');
        String answer = new String(String.valueOf(stars));
        String lastFourNumbers = phone_number.substring(phone_number.length() - 4);
        answer += lastFourNumbers;
        return answer;
    }
}