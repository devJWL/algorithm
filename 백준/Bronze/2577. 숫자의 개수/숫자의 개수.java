import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] counter = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;

        while(result != 0) {
            ++counter[result % 10];
            result /= 10;
        }

        for(int count : counter) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
