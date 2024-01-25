// 시간복잡도에 대해서 생각해보기
class Solution {
    public void BT(int r, int c, int len, int[] answer, int[][] arr) {
        int std = arr[r][c];
        // 탐색 범위의 모든 블럭이 같은 경우 false
        boolean check = false;
        
        for (int y = r; y < r + len; ++y) {
            for (int x = c; x < c + len; ++x) {
                if (std != arr[y][x]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        
        if (check) {
            len /= 2;
            BT(r, c, len, answer, arr);
            BT(r + len, c, len, answer, arr);
            BT(r, c + len, len, answer, arr);
            BT(r + len, c + len, len, answer, arr);
        }
        else {
            ++answer[std];
        }
    } 
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        BT(0, 0, n, answer, arr);
        return answer;
    }
}