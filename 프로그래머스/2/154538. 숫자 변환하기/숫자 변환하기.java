import java.util.*;


class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dist = new int[1000001];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            if (curr == y) return dist[curr];
            int[] arr = {curr + n, curr * 2, curr * 3};
            for (int next : arr) {
                if (next > 1000000) continue;
                if (dist[next] != -1) continue;
                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }
        return -1;
    }
}