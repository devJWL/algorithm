import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            Deque<Integer> deque = makeDeque(arr);
            boolean dir = true;
            boolean isError = false;

            for (char command : commands) {
                if (command == 'R') {
                    dir = !dir;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (dir) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if (dir) {
                    while (deque.size() > 1) {
                        bw.write(deque.pollFirst() + ",");
                    }
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "");
                    }
                } else {
                    while (deque.size() > 1) {
                        bw.write(deque.pollLast() + ",");
                    }
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static Deque<Integer> makeDeque(char[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;

        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] == ',') {
                deque.add(num);
                num = 0;
            } else {
                num = num * 10 + (arr[i] - '0');
            }
        }

        if (num != 0) {
            deque.add(num);
        }

        return deque;
    }
}