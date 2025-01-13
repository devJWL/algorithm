import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int[] counter = new int['z' - 'a' + 1];
        char[] word = s.toCharArray();

        for (char ch : word) {
            ++counter[ch - 'a'];
        }

        for (int count : counter) {
            bw.write(count + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
