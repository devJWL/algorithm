class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean[] alpha = new boolean[26];
        
        
        for (char ch : skip.toCharArray()) {
            // 스킵할 문자 체크
            alpha[ch - 'a'] = true;
        }
        
        for (char ch : s.toCharArray()) {
            int cnt = 0;
            while(cnt != index) {
                ch += 1;
                if (ch > 'z'){
                    ch = 'a';
                }
                // 스킵 알파벳이 아닌 경우
                if (!alpha[ch - 'a']) ++cnt;
            }
            sb.append(ch);
        }
        answer = sb.toString();
        return answer;
    }
}