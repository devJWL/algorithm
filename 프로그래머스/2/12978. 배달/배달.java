import java.util.*;


class Solution {
	final int INF = 1000000000;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N + 1][N + 1];
        
        for (int i = 0; i < graph.length; ++i) {
        	for (int j = 0; j < graph[i].length; ++j) {
        		if (i == j) {
        			graph[i][j] = 0;
        			graph[j][i] = 0;
        		} else {
        			graph[i][j] = INF;
        			graph[j][i] = INF;
        		}
        	}
        }
        
        for (int i = 0; i < road.length; ++i) {
        	int v1 = road[i][0];
        	int v2 = road[i][1];
        	int cost = road[i][2];
        	
        	graph[v1][v2] = Math.min(graph[v1][v2], cost);
        	graph[v2][v1] = Math.min(graph[v2][v1], cost);
        }
        
        for (int k = 1; k < graph.length; ++k) {
        	for (int i = 1; i < graph.length; ++i) {
        		for (int j = 1; j < graph.length; ++j) {
        			graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        			graph[j][i] = Math.min(graph[j][i], graph[j][k] + graph[k][i]);
        		}
        	}
        }
        
        for (int i = 1; i < graph.length; ++i) {
        	if (graph[1][i] <= K)
        		++answer;
        }
        
        return answer;
    }
}