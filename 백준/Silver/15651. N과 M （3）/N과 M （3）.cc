#include <bits/stdc++.h>

using namespace std;

void recur(int depth, string str, string notuse);

int N, M;

int main()
{
    std::ios::sync_with_stdio(false);
    cin >> N >> M;
    string str = "";
    string notuse;
    for (int i = 1; i <= N; ++i)
    {
        notuse.append(to_string(i));
    }
    recur(0, str, notuse);
    return 0;
}


void recur(int depth, string str, string notuse)
{
    if (depth == M)
    {
        for (int i = 0; i < str.length(); ++i)
        {
            cout << str[i] << " ";
        }

        cout << '\n';
        return;
    }

    for (int i = 0; i < notuse.length(); ++i)
    {
        str += notuse[i];
        recur(depth + 1, str, notuse);
        str.pop_back();
    }
}