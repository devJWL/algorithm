import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Set<String> set = new HashSet<>();

    static void solve(String str) {
        for (int left = 0; left <= str.length(); left++) {
            for (int right = left + 1; right <= str.length(); right++) {
                set.add(str.substring(left, right));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        solve(s);
        bw.write(set.size() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
