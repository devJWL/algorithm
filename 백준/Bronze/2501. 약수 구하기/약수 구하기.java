import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            int num = list.get(i);
            if (n % num == 0 && num * num != n) {
                list.add(n / num);
            }
        }

        if (list.size() < k) {
            bw.write("0\n");
        }
        else {
            bw.write(list.get(k - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
