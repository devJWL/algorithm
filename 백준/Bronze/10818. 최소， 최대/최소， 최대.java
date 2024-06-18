import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(br.readLine());
    List<Integer> list = Arrays.stream(br.readLine().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    bw.write(list.stream().min(Integer::compareTo).get() + " ");
    bw.write(list.stream().max(Integer::compareTo).get() + " ");

    br.close();
    bw.flush();
    bw.close();
  }
}