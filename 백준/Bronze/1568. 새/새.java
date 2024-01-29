import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1;
        int answer = 0;

        while(n > 0) {
            while(n >= num){
                n -= num;
                ++answer;
                ++num;
            }
            num = 1;
        }


        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}