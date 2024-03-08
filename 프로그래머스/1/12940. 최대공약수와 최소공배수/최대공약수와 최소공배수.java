class Solution {
    public int getGcd(int a, int b){
        int r = a % b;
        if (r == 0){
            return b;
        }
        return getGcd(b, r);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = getGcd(n, m);
        answer[0] = gcd;
        answer[1] = n * m / gcd;
        return answer;
    }
}