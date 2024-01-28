import java.io.*;
import java.util.*;



public class Main {

    public static boolean calc(String num1, String oper, String num2, String result) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int res = Integer.parseInt(result);

        switch(oper) {
            case "+":
                return n1 + n2 == res;
            case "-":
                return n1 - n2 == res;
            case "*":
                return n1 * n2 == res;
            default:
                return n1 / n2 == res;
        }
    }


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String res = "";
        for (int i = 1; i<= n; ++i) {
            String[] expression = br.readLine().split(" ");
            if (calc(expression[0], expression[1], expression[2], expression[4])) {
                res = "YES";
            } else {
                res = "NO";
            }
            bw.write(String.format("Case %d: %s\n", i, res));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}