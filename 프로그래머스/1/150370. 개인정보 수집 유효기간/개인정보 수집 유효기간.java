import java.util.*;


class Solution {
    
    public int getDays(String day, int month)  {
        String[] tokens = day.split("\\.");
        int y = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]) + month;
        int d = Integer.parseInt(tokens[2]);
        int days = y * 12 * 28 + m * 28 + d;
        return days;
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        
        for (String term : terms) {
            String[] tokens = term.split(" ");
            termsMap.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        
        int todays = getDays(today, 0);
        
        for (int i = 0; i < privacies.length; ++i) {
            String privacy = privacies[i];
            String[] tokens = privacy.split(" ");
            int privacydays = getDays(tokens[0], termsMap.get(tokens[1]));
            if (todays >= privacydays) {
                answer.add(i + 1);
            }
        }
    
        return answer;
    }
}