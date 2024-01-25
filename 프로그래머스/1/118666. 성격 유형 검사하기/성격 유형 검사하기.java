import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
    	StringBuilder sb = new StringBuilder(4);
        char[] kinds = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        Map<Character, Integer> scores = new HashMap<>();
        
        for (int i = 0; i < kinds.length; ++i)
        {
        	scores.put(kinds[i], 0);
        }
        
        for (int i = 0; i < survey.length; ++i)
        {
        	char[] data = survey[i].toCharArray();
        	char first = data[0];
        	char second = data[1];
        	
        	if (choices[i] < 4)
        	{
        		scores.put(first, scores.get(first) + (4 - choices[i]));
        	}
        	else if (choices[i] > 4)
        	{
        		scores.put(second, scores.get(second) + (choices[i] - 4));
        	}
        }
        
        for (int i = 0; i <= 6; i += 2)
        {
        	char ch1 = kinds[i];
        	char ch2 = kinds[i + 1];
        	
        	if (scores.get(ch1) > scores.get(ch2))
        	{
        		sb.append(ch1);
        	}
        	else if (scores.get(ch1) < scores.get(ch2))
        	{
        		sb.append(ch2);
        	}
        	else
        	{
        		sb.append(ch1);
        	}
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}