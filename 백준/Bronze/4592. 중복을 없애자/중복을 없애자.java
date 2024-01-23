import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int nums[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (nums[0] == 0) {
                break;
            }
            int prev = 100;
            List<Integer> answer = new ArrayList<>();

            for (int i = 1; i < nums.length; ++i) {
                if (prev != nums[i]){
                    prev = nums[i];
                    answer.add(nums[i]);
                }
            }

            for (int i = 0; i < answer.size(); ++i) {
                bw.write(answer.get(i) + " ");
            }
            bw.write("$\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}