import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String lhs = st.nextToken();
            String rhs = st.nextToken();
            bw.write(test(lhs.toCharArray(), rhs.toCharArray()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String test(char[] lhs, char[] rhs) {
        int[] counter = new int['z' - 'a' + 1];
        for (char ch : lhs) {
            ++counter[ch - 'a'];
        }
        for (char ch : rhs) {
            --counter[ch - 'a'];
        }

        for (int count : counter) {
            if (count != 0) return "Impossible";
        }
        return "Possible";
    }
}
