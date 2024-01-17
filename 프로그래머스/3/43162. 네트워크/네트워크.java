class Solution {
	public void DFS(int start, int[][] computers, boolean[] visited){
		if (visited[start])
			return;
		visited[start] = true;
		
		for (int i = 0; i < computers[start].length; ++i){
			if (start != i && computers[start][i] == 1 && !visited[i]){
				DFS(i, computers, visited);
			}
		}
	}
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; ++i){
			if (visited[i] == false){
				++answer;
				DFS(i, computers, visited);
			}
		}
		return answer;
	}
}
