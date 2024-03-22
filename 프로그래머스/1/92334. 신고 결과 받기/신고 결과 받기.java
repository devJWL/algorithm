import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportList = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();
        
        for (String id : id_list) {
            reportList.put(id, new HashSet<>());
            reportedCountMap.put(id, 0);
        }
        
        for (String repo : report) {
            String[] token = repo.split(" ");
            String reporter = token[0];
            String reportee = token[1];
            
            if (!reportList.get(reporter).contains(reportee)){
                reportList.get(reporter).add(reportee);
                reportedCountMap.put(reportee, reportedCountMap.get(reportee) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; ++i) {
            int cnt = 0;
            Set<String> set = reportList.get(id_list[i]);
            
            for (String id : set) {
                if (reportedCountMap.get(id) >= k) {
                    ++cnt;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}