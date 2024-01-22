
class Solution {
	int answer = 0;
    
	public boolean isPrime(int number) {
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) return false;
        }
        return true;
	}
	
	public void dfs(int[] nums, int index, int sum, int count) {
		if (count == 3) {
			if (isPrime(sum)) {
				++answer;
			}
			return;
		}
		
		if (index == nums.length)
			return;
        
		dfs(nums, index + 1, sum + nums[index], count + 1);
		dfs(nums, index + 1, sum, count);
	}
	
    public int solution(int[] nums) {
    	dfs(nums, 0, 0, 0);
        return answer;
    }
}