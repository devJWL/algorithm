import java.io.*;
import java.util.*;



public class Main {

    public static String task(String[] alias, String[] sameAlias, int first, int second) {
        if (first == second)  return sameAlias[first];
        if (first < second) {
            int temp = first;
            first = second;
            second = temp;
        }
        if (first == 6 && second == 5) return "Sheesh Beesh";
        return alias[first] + " " + alias[second];
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] alias = {"dummpy", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
        String[] sameAlias = {"dummpy", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; ++i) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(String.format("Case %d: %s\n", i, task(alias, sameAlias, nums[0], nums[1])));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}