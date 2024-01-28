import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int answer = 0;

        if (nums[1] - nums[0] == nums[2] - nums[1]) {
            answer = nums[2] + (nums[1] - nums[0]);
        } else {
            if (nums[1] - nums[0] > nums[2] - nums[1]) {
                answer = nums[0] + (nums[2] - nums[1]);
            } else {
                answer = nums[1] + (nums[1] - nums[0]);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}