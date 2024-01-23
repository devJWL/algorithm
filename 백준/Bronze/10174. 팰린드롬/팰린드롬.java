import java.io.*;
import java.util.*;



public class Main {

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < n; ++i) {
            String data = br.readLine().toLowerCase();
            if (isPalindrome(data)) {
                answer = "Yes";
            }
            else {
                answer = "No";
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}