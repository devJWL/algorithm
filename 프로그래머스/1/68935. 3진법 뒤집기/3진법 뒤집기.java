class Solution {
	
	long pow(int count) {
		long res = 1;
		for (int i = 1; i < count; ++i) {
			res *= 3;
		}
		return res;
	}
    public long solution(int n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
        	int remains = n % 3;
        	n /= 3;
        	char ch = (char)(remains + '0');
        	sb.append(ch);
        }
        
        long number = Long.parseLong(sb.toString());
        
        int i = 1;
        while(number != 0) {
        	long addNum = pow(i) * (number % 10);
        	answer = answer + addNum;
        	number /= 10;
        	++i;
        }
        System.out.println(answer);
        return answer;
    }
}