import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[] init;
    static int m;
    static String command;
    static List<Character> editor = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init = br.readLine().toCharArray();
        m = Integer.parseInt(br.readLine());
        for (char ch : init) {
            editor.add(ch);
        }

        ListIterator<Character> iter = editor.listIterator(editor.size());

        for (int i = 0; i < m; ++i) {
            command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    iter.add(command.charAt(2));

            }
        }

        for (char ch : editor) {
            bw.write(ch);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
왼쪽으로 이동 L -> 현재 pos > 0이면 pos 1 감소
오른쪽으로 이동 D -> 현재 pos < size pos 1 증가
삭제 B -> pos > 0 일때 pos-1 위치를 지우고 pos 1 감소
삽입 P -> 현재 위치에 추가 하고 pos 1증가
 */
