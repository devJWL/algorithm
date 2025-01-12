#include <bits/stdc++.h>

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n, x;
    int num;

    std::cin >> n >> x;

    for (int i = 0; i < n; ++i) {
        std::cin >> num;
        if (num < x) {
            std::cout << num << " ";
        }
    }
    return 0;
}