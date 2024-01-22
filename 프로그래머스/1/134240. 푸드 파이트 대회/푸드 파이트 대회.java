import java.util.*;


class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        
        for (int i = 1; i < food.length; ++i) {
            int cnt = food[i] / 2;
            while(cnt > 0) {
                sb.append((char)(i + '0'));
                --cnt;
            }
        }
        StringBuffer sb2 = new StringBuffer(sb.toString());
        sb2.reverse();
        sb.append('0').append(sb2.toString());
        answer = sb.toString();
        return answer;
    }
}