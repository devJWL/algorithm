import java.util.*;

class Solution {
    public String deleteZero(String s) {
        StringBuffer sb = new StringBuffer();
        char[] charArr = s.toCharArray();
        for (char ch : charArr){
            if (ch == '1') sb.append(ch);
        }
        return sb.toString();
    }
    
    public String toBinary(int number) {
        StringBuffer sb = new StringBuffer();
        while(number > 0) {
            sb.append(number % 2);
            number /= 2;
        }
        return sb.reverse().toString();
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            ++answer[0];
            answer[1] += s.length();
            s = deleteZero(s);
            answer[1] -= s.length();
            s = toBinary(s.length());
        }
        return answer;
    }
}