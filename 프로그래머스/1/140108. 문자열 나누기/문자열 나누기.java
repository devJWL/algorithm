class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int xCount = 0;
        int otherCount = 0;
        
        boolean start = false;
        char x = ' ';
        for (char ch : s.toCharArray()) {
            if (start) {
                if (ch == x) ++xCount;
                else ++otherCount;
            }
            else {
                x = ch;
                ++xCount;
                start = true;
            }
            if (xCount == otherCount) {
                ++answer;
                xCount = 0;
                otherCount = 0;
                start = false;
            }
        }
        
        if (xCount != otherCount) ++answer;
        
        return answer;
    }
}