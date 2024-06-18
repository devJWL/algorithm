import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(br.readLine());
    List<Integer> arr = Arrays.stream(br.readLine().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    
    int v = Integer.parseInt(br.readLine());

    bw.write(arr.stream().filter(e -> e == v).count() + " ");
    br.close();
    bw.flush();
    bw.close();
  }
}