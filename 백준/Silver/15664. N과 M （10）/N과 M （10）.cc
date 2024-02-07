#include <bits/stdc++.h>

int n, m;
std::vector<int> vec;
std::vector<std::string> s;
std::vector<bool> check;
std::set<std::vector<std::string>> set;

void BT(int k)
{
    if (s.size() == m)
    {
        if (set.find(s) == set.end())
        {
            set.insert(s);
            for (auto ch : s)
            {
                std::cout << ch << " ";
            }
            std::cout << '\n';
        }
        return;
    }

    for (int i = k; i < vec.size(); ++i)
    {
        if (!check[i])
        {
            s.emplace_back(std::to_string(vec[i]));
            check[i] = true;
            BT(i);
            s.pop_back();
            check[i] = false;
        }
    }
}

int main()
{
    std::ios::sync_with_stdio(false);
    std::cout.tie(nullptr);
    std::cin.tie(nullptr);

    std::cin >> n >> m;

    vec.reserve(n);
    check.reserve(n);
    std::fill(check.begin(), check.end(), false);

    for (int i = 0; i < n; ++i)
    {
        int num;
        std::cin >> num;
        vec.emplace_back(num);
    }

    std::sort(vec.begin(), vec.end());

    BT(0);
    return 0;
}