import java.util.*;



class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        
        StringBuffer sb = new StringBuffer();
        for (String num : nums) {
            sb.append(num);
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}