class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0){
            int n = storey % 10;

            if (n >= 6 || (n == 5 && (storey / 10) % 10 >= 5)){
                storey += 10 - n;  // carry 변수 대신 올림을 표현
                answer += 10 - n;
            }
            else {
                answer += n;
            }
            storey /= 10;
        }
        return answer;
    }
}