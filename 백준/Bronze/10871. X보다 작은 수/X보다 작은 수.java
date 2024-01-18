import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] answer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(e -> e < x).toArray();

        for (int val : answer) {
            bw.write(val + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
