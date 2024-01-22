class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] dayNames = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        
        for (int i = 0; i < a - 1; ++i) {
            count += days[i];
        }
        count += (b - 1);
        
        answer = dayNames[count % 7];
        return answer;
    }
}