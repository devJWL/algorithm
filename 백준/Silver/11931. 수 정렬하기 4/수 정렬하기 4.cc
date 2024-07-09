#include <bits/stdc++.h>


int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n;
    std::cin >> n;
    std::vector<int> vec(n);

    for (int i = 0; i < n; ++i)
    {
        std::cin >> vec[i];
    }

    std::sort(vec.begin(), vec.end(),
              [](int a, int b) -> bool
              {
                return a > b;
              }
              );

    for (int i = 0; i < n; ++i)
    {
        std::cout << vec[i] << "\n";
    }
    return 0;
}