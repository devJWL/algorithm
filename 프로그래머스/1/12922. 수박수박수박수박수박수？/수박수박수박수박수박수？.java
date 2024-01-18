class Solution {
    public String solution(int n) {
        char[] ch = { '수', '박'};
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; ++i){
            sb.append(ch[i % 2]);
        }
        return sb.toString();
    }
}