import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        boolean flag = false;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < X.length(); ++i) {
            char ch = X.charAt(i);
            ++n1[ch - '0'];
        }

        for (int i = 0; i < Y.length(); ++i) {
            char ch = Y.charAt(i);
            ++n2[ch - '0'];
        }

        for (int i = 9; i >= 0; --i) {
            int min = Math.min(n1[i], n2[i]);
            for (int j = 0; j < min; ++j){
                sb.append((char)(i + '0'));
            }
        }
        
        if (sb.length() == 0)
            answer = "-1";
        else {
            answer = sb.toString();
            if (answer.charAt(0) == '0'){
                answer = "0";
            }
        }
        return answer;
    }
}