#include <bits/stdc++.h>

int n;
std::vector<int> graph[100001];
int p[100001];

void dfs(int curr){
    for (int next : graph[curr]){
        if (p[curr] == next) continue;
        p[next] = curr;
        dfs(next);
    }
}
int main()
{ 
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);

    std::cin >> n;
    for (int i = 0; i < n - 1; ++i){
        int u, v;
        std::cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    dfs(1);

    for (int i = 2; i <= n; ++i){
        std::cout << p[i] << "\n";
    }
    return 0;
}