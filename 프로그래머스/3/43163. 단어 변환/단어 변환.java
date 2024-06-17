import java.util.*;

public class Solution {

  int answer = 0;
  public boolean[] visit;

  public boolean hasWord(String target, String[] words) {
    for (String word : words) {
      if (word.equals(target)) {
        return true;
      }
    }
    return false;
  }

  public boolean isOneDiff(String currWord, String anotherWord) {
    int count = 0;
    for (int i = 0; i < currWord.length(); i++) {
      if (currWord.charAt(i) != anotherWord.charAt(i)) {
        ++count;
      }
    }
    return count == 1;
  }

  public void bfs(String currWord, String target, String[] words, int count) {
    if (currWord.equals(target)) {
      answer = Math.min(answer, count);
      return;
    }

    for (int i = 0; i < words.length; ++i) {
      if (visit[i] == false && isOneDiff(currWord, words[i])) {
        visit[i] = true;
        bfs(words[i], target, words, count + 1);
        visit[i] = false;
      }
    }
  }

  public int solution(String begin, String target, String[] words) {
    final int notHasValue = 0;
    answer = words.length;
    visit = new boolean[words.length];

    if (!hasWord(target, words)) {
      return notHasValue;
    }

    bfs(begin, target, words, 0);

    return answer;
  }
}