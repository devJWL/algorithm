import java.util.Arrays;

class Solution {
	
	public int select(int[] array, int diff)
	{
		Arrays.sort(array);
		return array[diff];
	}
	
    public int[] solution(int[] array, int[][] commands) {
    	
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; ++i)
        {
        	int[] arr = new int[commands[i][1] - commands[i][0] + 1];
        	int k = 0;
        	
        	for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; ++j)
        	{
        		arr[k] = array[j];
        		++k;
        	}
        	answer[i] = select(arr, commands[i][2] - 1);
        }
        return answer;
    }
}