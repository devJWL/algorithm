import java.util.*;

public class Solution {

public String makeSequence(int n, int t, int m) {
    Map<Integer, Character> map = new HashMap<>();
    map.put(0, '0'); map.put(1, '1'); map.put(2, '2'); map.put(3, '3'); map.put(4, '4'); map.put(5, '5');
    map.put(6, '6'); map.put(7, '7'); map.put(8, '8'); map.put(9, '9'); map.put(10, 'A'); map.put(11, 'B');
    map.put(12, 'C'); map.put(13, 'D'); map.put(14, 'E'); map.put(15, 'F');

    StringBuilder sb = new StringBuilder();
    StringBuilder result = new StringBuilder();
    result.append(0);

    for (int i = 1; result.length() < t * m; ++i) {
      int number = i;
      while (number > 0) {
        int digit = number % n;
        sb.append(map.get(digit));
        number /= n;
      }
      result.append(sb.reverse());
      sb.delete(0, sb.length());
    }

    return result.toString();
  }

  public String solution(int n, int t, int m, int p) {
    StringBuilder sb = new StringBuilder();
    String sequence = makeSequence(n, t, m);

    int offset = p - 1;
    for (int i = offset; sb.length() < t; i += m) {
      sb.append(sequence.charAt(i));
    }
    return sb.toString();
  }
}