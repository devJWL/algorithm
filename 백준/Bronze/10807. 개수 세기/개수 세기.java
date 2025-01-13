import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(br.readLine());

        long count = Arrays.stream(nums).filter(num -> num == v).count();

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
