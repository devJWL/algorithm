import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });
        
        for (int i = row_begin; i <= row_end; ++i) {
            int sum = 0;
            for (int num : data[i - 1]) {
                sum += (num % i);
            }
            answer ^= sum;
        }
        return answer;
    }
}

/*
[
    [2,2,6],
    [1,5,10],
    [4,2,9],
    [3,8,3]
]

오름차순으로 정렬 후
[
    [2, 2, 6],
    [4, 2, 9],
    [1, 5, 10],
    [3, 8, 3]
]

내림차순으로 정렬 후
[
    [4, 2, 9],
    [2, 2, 6],
    [1, 5, 10],
    [3, 8, 3]  여기까지 오키
]
*/