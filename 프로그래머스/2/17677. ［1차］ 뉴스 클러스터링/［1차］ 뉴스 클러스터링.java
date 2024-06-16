import java.util.*;

public class Solution {

  public boolean check(String element) {
   if (element.length() < 2) {
     return false;
   }
   if (element.charAt(0) < 'a' || element.charAt(0) > 'z') {
     return false;
   }
    return element.charAt(1) >= 'a' && element.charAt(1) <= 'z';
  }

  public Map<String, Integer> makeElement(String str) {
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> result = new HashMap<>();

    sb.append(str.charAt(0));
    for (int i = 1; i < str.length(); ++i) {
      sb.append(str.charAt(i));
      String element = sb.toString();

      if (check(sb.toString())) {
        result.put(element, result.getOrDefault(element, 0) + 1);
      }

      sb.deleteCharAt(0);
    }
    return result;
  }

  public int calcInterSection(Map<String, Integer> group1, Map<String, Integer> group2) {
    int value = 0;
    for (Map.Entry<String, Integer> entry : group1.entrySet()) {
      if (group2.containsKey(entry.getKey())) {
        value += Math.min(entry.getValue(), group2.get(entry.getKey()));
      }
    }
    return value;
  }

  public int calcUnion(Map<String, Integer> group1, Map<String, Integer> group2) {
    int value = 0;

    for (Map.Entry<String, Integer> entry : group1.entrySet()) {
      if (group2.containsKey(entry.getKey())) {
        value += Math.max(entry.getValue(), group2.get(entry.getKey()));
      }
      else {
        value += entry.getValue();
      }
    }

    for (Map.Entry<String, Integer> entry : group2.entrySet()) {
      if (!group1.containsKey(entry.getKey())) {
        value += entry.getValue();
      }
    }

    return value;
  }

  public int solution(String str1, String str2) {
    int multi = 65536;

    Map<String, Integer> group1 = makeElement(str1.toLowerCase());
    Map<String, Integer> group2 = makeElement(str2.toLowerCase());

    int intersection = calcInterSection(group1, group2);
    int union = calcUnion(group1, group2);

    if (intersection == 0 && union == 0) {
      return multi;
    }
    return (int)((double)intersection / union * multi);
  }
}