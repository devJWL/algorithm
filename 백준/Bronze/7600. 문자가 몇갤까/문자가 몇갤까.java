import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String sentence = br.readLine();
            if (sentence.charAt(0) == '#') break;
            boolean[] check = new boolean[26];
            sentence = sentence.toLowerCase();
            int count = 0;
            for (int i = 0; i < sentence.length(); ++i) {
                char ch = sentence.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    if (check[ch - 'a']) continue;
                    check[ch - 'a'] = true;
                    ++count;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}