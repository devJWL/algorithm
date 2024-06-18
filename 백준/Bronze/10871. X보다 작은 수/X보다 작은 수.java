import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  public static void main(String[] args) throws IOException {

    String[] nx = br.readLine().split(" ");
    int n = Integer.parseInt(nx[0]);
    int x = Integer.parseInt(nx[1]);
    List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .filter(num -> num < x)
        .collect(Collectors.toList());

    for (int a : arr) {
      bw.write(a + " ");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}