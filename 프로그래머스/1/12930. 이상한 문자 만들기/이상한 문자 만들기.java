
class Solution {
    public String solution(String s) {
    	char[] arr = s.toCharArray();
    	int index = 0;
    	
    	for (int i = 0; i < arr.length; ++i) {
    		char ch = arr[i];
    		if (arr[i] == ' ') {
    			index = 0;
    			continue;
    		}
    		if (index % 2 == 0) {
    			arr[i] = Character.toUpperCase(ch);
    		}
    		else {
    			arr[i] = Character.toLowerCase(ch);
    		}
    		++index;
    	}
        return String.valueOf(arr);
    }
}