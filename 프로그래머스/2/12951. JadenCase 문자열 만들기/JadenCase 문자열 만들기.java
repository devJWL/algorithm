import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            char ch = str.charAt(0);
            if (ch == ' ') {
                sb.append(ch);
                continue;
            }
            else if (ch >= 'a' && ch <= 'z') {
                char upper = (char)(ch - ('a' - 'A'));
                sb.append(upper);
            }
            else {
                sb.append(ch);
            }
            sb.append(str.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}
