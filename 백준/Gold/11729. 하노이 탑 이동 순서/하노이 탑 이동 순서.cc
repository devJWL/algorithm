#include <bits/stdc++.h>


int n, k;
std::vector<std::pair<int, int>> ans;
void hanoi(int curr, int from, int temp, int to) {
    ++k;
    if (curr == 1){
        ans.push_back({from, to});
        return;
    }
    hanoi(curr - 1, from, to, temp);
    ans.push_back({from, to});
    hanoi(curr - 1, temp, from, to);
}


int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cin >> n;

    hanoi(n, 1, 2, 3);
    std::cout << k << '\n';
    for (auto [from, to] : ans){
        std::cout << from << ' ' << to << '\n';
    }
    return 0;
}