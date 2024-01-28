import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] serials = new String[n];
        for (int i = 0; i < n; ++i) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                int sum1 = 0, sum2 = 0;
                for (char ch : o1.toCharArray()) {
                    if (ch >= '0' && ch <= '9') {
                        sum1 += ch - '0';
                    }
                }
                for (char ch : o2.toCharArray()) {
                    if (ch >= '0' && ch <= '9') {
                        sum2 += ch - '0';
                    }
                }
                if (sum1 == sum2) {
                    return o1.compareTo(o2);
                }
                return sum1 - sum2;
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < n; ++i) {
            bw.write(serials[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}