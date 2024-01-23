import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        if (s.charAt(0) != '0') {
            bw.write(s);
        }
        else {
            Map<Character, Integer> map = new HashMap<>();
            char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int i = 0; i < nums.length; ++i) {
                map.put(nums[i], i);
            }

            int sum = 0;
            int unit = 1;

            if (s.charAt(1) == 'x') {
                for (int i = s.length() - 1; i >= 2; --i) {
                    sum += map.get(s.charAt(i)) * unit;
                    unit *= 16;
                }
            }
            else {
                for (int i = s.length() - 1; i >= 1; --i) {
                    sum += map.get(s.charAt(i)) * unit;
                    unit *= 8;
                }
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}