import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] dy = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    static int[] dx = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    static int[][] image;
    static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        image = new int[N][N];

        for (int i = 0; i < N; ++i) {
            image[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recursive(N, 0, 0);

        for (int count : counts) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.flush();
        br.close();
    }

    private static void recursive(int n, int y, int x) {
        if (isCompressible(n, y, x)) {
            int color = image[y][x] + 1;
            ++counts[color];
            return;
        }

        int nn = n / 3;

        for (int dir = 0; dir < 9; ++dir) {
            int ny = y + nn * dy[dir];
            int nx = x + nn * dx[dir];
            recursive(nn, ny, nx);
        }
    }

    public static boolean isCompressible(int n, int y, int x) {
        int color = image[y][x];

        for (int i = y; i < y + n; ++i) {
            for (int j = x; j < x + n; ++j) {
                if(color != image[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}