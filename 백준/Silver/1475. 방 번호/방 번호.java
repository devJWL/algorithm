import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] counter = new int[10];

        int n = Integer.parseInt(br.readLine());

        while(n != 0) {
            ++counter[n % 10];
            n /= 10;
        }

        int value = (counter[6] + counter[9] + 1) / 2;
        counter[6] = value;
        counter[9] = value;

        int answer = Integer.MIN_VALUE;

        for (int count : counter) {
            answer = Math.max(answer, count);
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
