import java.io.*;
import java.util.*;



public class Main {

    public static int act(int h, char[] actions) {
        for (char action : actions) {
            if (action == 'c') {
                ++h;
            }
            else {
                --h;
            }
        }
        return h;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= k; ++i) {
            int h = Integer.parseInt(br.readLine());
            char[] actions = br.readLine().toCharArray();

            bw.write(String.format("Data Set %d:\n%d\n\n", i, act(h, actions)));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}