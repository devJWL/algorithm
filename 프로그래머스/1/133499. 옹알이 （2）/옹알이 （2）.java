class Solution {
    
    public boolean isPronun(String str) {
        String[] pronus = {"aya", "ye", "woo", "ma"};
        int idx = 0;
        int prev = -1;
        boolean flag = false;
        while(idx < str.length()) {
            flag = false;
            for (int i = 0; i < pronus.length; ++i) {
                if (prev != i && str.startsWith(pronus[i], idx)){
                    idx += pronus[i].length();
                    prev = i;
                    flag = true;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
    
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            if (isPronun(str)) ++answer;
        }   
        return answer;
    }
}