import java.io.*;
import java.util.*;



public class Main {

    public static void task(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[21];
        for (int i = 1; i <= 20; ++i) {
            nums[i] = i;
        }

        for (int i = 0; i < 10; ++i) {
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            task(nums, range[0], range[1]);
        }


        for (int i = 1; i <= 20; ++i) {
            bw.write(nums[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}