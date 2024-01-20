import java.util.*;


class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        
        map.put("code", 0); map.put("date", 1); map.put("maximum", 2); map.put("remain", 3);
        
        int extIndex = map.get(ext);
        int sortByIndex = map.get(sort_by);
        
        for (int[] datum : data) {
            if (datum[extIndex] < val_ext) {
                list.add(datum);
            }
        }
        
        list.sort((o1, o2) -> o1[sortByIndex] - o2[sortByIndex]);
        
        int[][] answer = new int[list.size()][];
        
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
