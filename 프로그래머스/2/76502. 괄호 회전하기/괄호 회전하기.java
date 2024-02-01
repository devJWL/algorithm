import java.util.*;


class Solution {
    private boolean isVaild(String s, int offset) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        int i = offset;
        do {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (ch == ')') {
                    if (st.pop() != '(') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (st.pop() != '{') {
                        return false;
                    }
                } else {
                    if (st.pop() != '[') {
                        return false;
                    }
                }
            }
            i = (i + 1) % len;
        }while(i != offset);

        if (st.isEmpty()) {
            return true;
        }
        return false;
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (isVaild(s, i)) {
                ++answer;
            }
        }
        return answer;
    }
}