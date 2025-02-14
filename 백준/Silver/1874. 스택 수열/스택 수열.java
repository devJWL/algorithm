import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        Stack<Integer> st = new Stack<>();
        List<Character> answers = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int curr = 0;
    
        for (int i = 1; i <= n; ++i) {
            st.add(i);
            answers.add('+');
            while(!st.isEmpty() && st.peek() == nums[curr]) {
                answers.add('-');
                st.pop();
                ++curr;
            }
        }
        
        if (st.isEmpty()) {
            for (char ch : answers) {
                bw.write(ch + "\n");
            }
        }
        else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}