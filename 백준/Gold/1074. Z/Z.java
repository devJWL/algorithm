import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, R, C;
    static int count;
    static int[] dr = {0, 0, 1, 1};
    static int[] dc = {0, 1, 0, 1};

    // 나, 오른쪽, 아래, 대각선 아래 방문 순서
    public static void main(String[] args) throws IOException {
        int[] NRC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = NRC[0];
        R = NRC[1];
        C = NRC[2];

        traverse(1 << N, 0, 0);

        bw.flush();
        bw.flush();
        br.close();
    }

    public static void traverse(int n, int r, int c) throws IOException {
        if (r == R && c == C) {
            bw.write(count + "\n");
            return;
        }

        if (!isContain(n, r, c))  {
            count += n * n;
            return;
        }

        n >>= 1;

        for (int dir = 0; dir < 4; ++dir) {
            int nr = r + n * dr[dir];
            int nc = c + n * dc[dir];
            traverse(n, nr, nc);
        }
    }

    private static boolean isContain(int n, int r, int c) {
        return r <= R && R < r + n && c <= C && C < c + n;
    }
}