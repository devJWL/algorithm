import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String name = br.readLine();
            char[] chars = name.toCharArray();
            int bad = 0;
            int good = 0;

            for (char ch : chars) {
                if (ch == 'b' || ch == 'B') {
                    ++bad;
                }
                else if (ch == 'g' || ch == 'G') {
                    ++good;
                }
            }

            String what = "";

            if (good > bad) {
                what = "GOOD";
            }
            else if (good < bad) {
                what = "A BADDY";
            }
            else {
                what = "NEUTRAL";
            }

            bw.write(String.format("%s is %s\n", name, what));
        }
        bw.flush();
        bw.close();
        br.close();
    }

}