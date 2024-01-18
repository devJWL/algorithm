import java.io.*;
import java.util.*;



public class Main {

    public static int calcYear(int year, int month, int day) {
        int returnYear = year * 10000 + month * 100 + day;
        return -returnYear;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String minName = "";
        int minYear = calcYear(1990, 1, 1);
        String maxName = "";
        int maxYear = calcYear(2010, 12, 31);

        int n = Integer.valueOf(br.readLine());

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int day = Integer.valueOf(st.nextToken());
            int month =  Integer.valueOf(st.nextToken());
            int year =  Integer.valueOf(st.nextToken());

            int returnYear = calcYear(year, month, day);

            if (returnYear < minYear) {
                minYear = returnYear;
                minName = name;
            }

            if (returnYear > maxYear) {
                maxYear = returnYear;
                maxName = name;
            }
        }


        bw.write(minName + "\n");
        bw.write(maxName + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
