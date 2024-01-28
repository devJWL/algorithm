import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] word = br.readLine().toCharArray();

        int answer = word.length;

        for (int i = 1; i < word.length; ++i) {
            if (word[i] == '-') {
                if (word[i - 1] == 'c' || word[i - 1] == 'd') {
                    answer -= 1;
                }
            } else if (word[i] == '='){
                if (word[i - 1] == 'c' || word[i - 1] == 's') {
                    answer -= 1;
                } else {
                    if (i >= 2 && word[i - 2] == 'd') {
                        answer -= 2;
                    }
                    else {
                        answer -= 1;
                    }
                }
            } else if (word[i] == 'j') {
                if (word[i - 1] == 'l' || word[i - 1] == 'n') {
                    answer -= 1;
                }
            }
        }


        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}