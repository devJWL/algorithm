#include <bits/stdc++.h>


int arr[9];
int n, m;


void dfs(int cur, int k) {
    if (k == m){
        for (int i = 0; i < m; ++i){
            std::cout << arr[i] << ' ';
        }
        std::cout << '\n';
        return;
    }
    if (cur == n + 1) return;

    arr[k] = cur;
    dfs(cur + 1, k + 1);
    dfs(cur + 1, k);
}


int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> m;
    
    dfs(1, 0);
    return 0;
}