import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());


        while(t-- > 0) {
            int cost = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            while(n-- >0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                int optionCost = Integer.parseInt(st.nextToken());
                cost += count * optionCost;
            }
            bw.write(cost + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
