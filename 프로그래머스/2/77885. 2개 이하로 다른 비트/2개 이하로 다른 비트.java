class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            long number = numbers[i];
            if ((number & 1) == 0) {
                answer[i] = number + 1;
            }
            else {
                int cnt = 0;
                long flag = 1;
                while((number & (flag << cnt)) != 0) {
                    ++cnt;
                }
                number += (flag << cnt);
                number -= (flag << (cnt - 1));
                answer[i] = number;
            }
        }
        return answer;
    }
}