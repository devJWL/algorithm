import java.util.*;


class Solution {
    int answer;
    List<Integer>[] graph;
    
    public void tour(int v1, int v2, int n) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visit[v1] = visit[v2] = true;
        int cnt = 1;
        q.offer(v1);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (visit[next]) continue;
                q.offer(next);
                visit[next] = true;
                ++cnt;
            }
        }
        answer = Math.min(answer, Math.abs(2 * cnt - n));
    }
    
    public int solution(int n, int[][] wires) {
        answer = n;
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for (int[] wire : wires) {
            tour(wire[0], wire[1], n);
        }
        return answer;
    }
}