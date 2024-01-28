import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; ++i) {
            int[] lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = lengths[0] / lengths[1];
            bw.write(answer * answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}