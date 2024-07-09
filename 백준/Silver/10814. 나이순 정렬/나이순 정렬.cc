#include <bits/stdc++.h>

int n;
int age;
std::string name;


int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n;
    std::vector<std::pair<int, std::string>> members;

    for (int i = 0; i < n; ++i) {
        std::cin >> age >> name;
        members.emplace_back(age, name);
    }

    std::stable_sort(members.begin(), members.end(), []
    (const auto & lhs, const auto & rhs) -> bool {
        return lhs.first < rhs.first;
    });

    for (const auto & member : members) {
        std::cout << member.first << " " << member.second << "\n";
    }
    return 0;
}