import java.util.*;


class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] used;
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public void BT(int depth, StringBuffer sb, String numbers){
        if (sb.length() > 0) {
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); ++i) {
            if (used[i]) continue;
            sb.append(numbers.charAt(i));
            used[i] = true;
            BT(depth + 1, sb, numbers);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
    
    public int solution(String numbers) {
        StringBuffer sb = new StringBuffer();
        used = new boolean[numbers.length()];
        BT(0, sb, numbers);
        return set.size();
    }
}