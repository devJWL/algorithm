import java.util.*;


class Solution {
    public int transTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + min;
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> ansMap = new TreeMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNumber = st.nextToken();
            String inOut = st.nextToken();
            
            if (inOut.equals("IN")) {
                map.put(carNumber, time);
            }
            else {
                int out = transTime(time);
                int in = transTime(map.get(carNumber));
                int duration = out - in;
                ansMap.put(carNumber, ansMap.getOrDefault(carNumber, 0) + duration);
                map.remove(carNumber);
            }
        }
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String carNumber = entry.getKey();
            int out = 23 * 60 + 59;
            int in = transTime(entry.getValue());
            int duration = out - in;
            ansMap.put(carNumber, ansMap.getOrDefault(carNumber, 0) + duration);
        }
        
        
        for (Map.Entry<String, Integer> entry : ansMap.entrySet()) {
            String carNumber = entry.getKey();
            int duration = entry.getValue();
            if (duration <= fees[0]) {
                ansMap.put(carNumber, fees[1]);
            }
            else {
                duration -= fees[0];
                int unit = duration / fees[2];
                if (duration % fees[2] > 0) {
                    unit += 1;
                }
                ansMap.put(carNumber, fees[1] + unit * fees[3]);
            }
        }
        
        List<Integer> list = new ArrayList<>(ansMap.values());
        int[] answer = new int[list.size()];
        
 
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}