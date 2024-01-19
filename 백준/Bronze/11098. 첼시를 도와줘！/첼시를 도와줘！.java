import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int cost;
        String answer;

        while(n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            cost = 0;
            answer = "";
            for (int i = 0; i < m; ++i) {
                String[] info = br.readLine().split(" ");
                int currCost = Integer.parseInt(info[0]);
                String currPlayer = info[1];

                if (currCost > cost) {
                    cost = currCost;
                    answer = currPlayer;
                }
            }
            System.out.println(answer);
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
