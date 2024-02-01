import java.util.*;
import java.io.*;



public class Main {
    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public static boolean hasNext(int[] nums) {

        int idx = nums.length - 1;
        while(idx > 0 && nums[idx - 1] > nums[idx]) {
            --idx;
        }
        int idx1 = idx - 1;

        if (idx1 < 0) return false;


        int idx2 = nums.length - 1;
        while(nums[idx1] > nums[idx2]) {
            --idx2;
        }
        
        swap(nums, idx1, idx2);

        ++idx1;
        idx2 = nums.length - 1;

        while(idx1 <= idx2) {
            swap(nums, idx1, idx2);
            ++idx1;
            --idx2;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (hasNext(nums)) {
            for (int i = 0; i < nums.length; i++) {
                bw.write(nums[i] + " ");
            }
            bw.write("\n");
        }
        else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}