import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Set<String> set = new HashSet<>();
    static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        for (int i = 0; i < n; ++i) {
            String name = br.readLine();
            set.add(name);
        }

        for (int i = 0; i < m; ++i) {
            String name = br.readLine();
            if (set.contains(name)) {
                names.add(name);
            }
        }

        Collections.sort(names);
        
        bw.write(names.size() + "\n");
        for (String name : names) {
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
