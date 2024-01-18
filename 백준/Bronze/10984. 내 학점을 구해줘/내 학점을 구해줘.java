import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cSum = 0;
            double gSum = 0.0;
            for (int i = 0; i < n; ++i){
                String[] scores = br.readLine().split(" ");
                int c = Integer.parseInt(scores[0]);
                double g = Double.parseDouble(scores[1]);

                cSum += c;
                gSum += (c * g);
            }
            bw.write(String.format("%d %.1f\n", cSum, gSum / cSum));
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
