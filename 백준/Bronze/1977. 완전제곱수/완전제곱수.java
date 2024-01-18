import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean isSquareNumber(int number) {
        int countOfDivisor = 0;

        for (int i =  1; i * i <= number; ++i) {
            if (number % i == 0) {
                if (i * i == number) {
                    countOfDivisor += 1;
                }
                else {
                    countOfDivisor += 2;
                }
            }
        }
        return (countOfDivisor & 1) == 1;
    }
    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;

        for (int i = m; i <= n; ++i) {
            if (isSquareNumber(i)) {
                sum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (min == -1) {
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
