import java.util.*;

public class Solution {

  String[][] values = new String[51][51];
  int[][] parent = new int[51][51];

  List<String> ans = new ArrayList<>();

  public void update(String[] tokens) {

    if (tokens.length == 4) {
      int r = Integer.parseInt(tokens[1]);
      int c = Integer.parseInt(tokens[2]);
      String value = tokens[3];
      int root = parent[r][c];

      for (int i = 1; i <= 50; ++i) {
        for (int j = 1; j <= 50; ++j) {
          if (parent[i][j] == root) {
            values[i][j] = value;
          }
        }
      }
    }
    else {
      String value1 = tokens[1];
      String value2 = tokens[2];

      for (int i = 1; i <= 50; ++i) {
        for (int j = 1; j <= 50; ++j) {
          if (values[i][j] != null && values[i][j].equals(value1)) {
            values[i][j] = value2;
          }
        }
      }
    }
  }

  public void mergeHelper(int root1, int root2, String value) {
    for (int i = 1; i <= 50; ++i) {
      for (int j = 1; j <= 50; ++j) {
        if (parent[i][j] == root1) {
          parent[i][j] = root2;
          values[i][j] = value;
        }
      }
    }
  }

  public void merge(String[] tokens) {
    int r1 = Integer.parseInt(tokens[1]);
    int c1 = Integer.parseInt(tokens[2]);
    int r2 = Integer.parseInt(tokens[3]);
    int c2 = Integer.parseInt(tokens[4]);

    int root1 = parent[r1][c1];
    int root2 = parent[r2][c2];

    if (root1 == root2) {
      return;
    }

    String value1 = values[root1 / 10000][root1 % 10000];
    String value2 = values[root2 / 10000][root2 % 10000];

    if (value1 == null) {
      mergeHelper(root1, root2, value2);
    }
    else {
      mergeHelper(root2, root1, value1);
    }
  }

  public void unmerge(String[] tokens) {
    int r = Integer.parseInt(tokens[1]);
    int c = Integer.parseInt(tokens[2]);

    int root = parent[r][c];
    String value = values[r][c];

    for (int i = 1; i <= 50; ++i) {
      for (int j = 1; j <= 50; ++j) {
        if (parent[i][j] == root) {
          parent[i][j] = i * 10000 + j;
          values[i][j] = null;
        }
      }
    }
    values[r][c] = value;

  }

  public void print(String[] tokens) {
    int r = Integer.parseInt(tokens[1]);
    int c = Integer.parseInt(tokens[2]);

    String value = values[r][c];
    if (value == null) {
      ans.add("EMPTY");
    }
    else {
      ans.add(value);
    }
  }

  public String[] solution(String[] commands) {
    String[] answer;

    for (int i = 1; i < values.length; ++i) {
      for (int j = 1; j < values[0].length; ++j) {
        int root = i * 10000 + j;
        parent[i][j] = root;
      }
    }

    for (String command : commands) {
      String[] tokens = command.split(" ");
      String cmd = tokens[0];
      if (cmd.equals("UPDATE")) {
        update(tokens);
      } else if (cmd.equals("MERGE")) {
        merge(tokens);
      } else if (cmd.equals("UNMERGE")) {
        unmerge(tokens);
      } else {
        print(tokens);
      }
    }

    answer = new String[ans.size()];
    for (int i = 0; i < ans.size(); ++i) {
      answer[i] = ans.get(i);
    }

    return answer;
  }
}