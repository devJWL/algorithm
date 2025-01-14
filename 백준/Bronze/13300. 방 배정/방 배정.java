import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[][] count = new int[2][7];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ++count[s][y];
        }

        for (int i = 0; i < 2; ++i) {
            for (int j = 1; j < 7; ++j) {
                answer += (count[i][j] + 1) / 2;
            }
        }


        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
