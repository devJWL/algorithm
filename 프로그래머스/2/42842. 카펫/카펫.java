class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int i = 3;
        int j = 0;
        int bCount = 0;
        while(true){
            j = 3;
            while(i >= j){
                bCount = 2 * (i + j - 2);
                if (i * j == sum && (bCount + yellow == sum)){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
                ++j;
            }
            ++i;
        }
    }
}