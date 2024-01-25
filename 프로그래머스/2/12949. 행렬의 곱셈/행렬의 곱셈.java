class Solution {
    private int res(int i, int j, int[][] arr1, int[][] arr2){
        int result = 0;
        for (int k = 0; k < arr1[0].length; ++k) {
            result += (arr1[i][k] * arr2[k][j]);
        }
        return result;
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                answer[i][j] = res(i, j, arr1, arr2);
            }
        }
        return answer;
    }
}