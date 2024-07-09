#include <bits/stdc++.h>

std::string word;
std::vector<std::string> prefixes;

int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> word;

    for (int i = 0; i < word.length(); ++i) {
        prefixes.emplace_back(word.substr(i));
    }

    std::sort(prefixes.begin(), prefixes.end());

    for (const std::string & prefix : prefixes) {
        std::cout << prefix << "\n";
    }

    return 0;
}