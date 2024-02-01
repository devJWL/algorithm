import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> setAll = new HashSet<>();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(input[i]);
            setA.add(num);
            setAll.add(num);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            Integer num = Integer.parseInt(input[i]);
            setB.add(Integer.parseInt(input[i]));
            setAll.add(num);
        }

        setAll.removeIf(num -> setA.contains(num) && setB.contains(num));

        bw.write(setAll.size() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}