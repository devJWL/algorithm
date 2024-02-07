#include <iostream>
#include <vector>

using namespace std;

void recur(string& str, int depth, int goal, vector<bool>& used);

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N, M;
    cin >> N >> M;
    string str = "";
    vector<bool> used(N + 1, false);
    recur(str, 0, M, used);
    return 0;
}

void recur(string& str, int depth, int goal, vector<bool>& used)
{
    if (depth == goal)
    {
        for (int i = 0; i < str.size(); ++i)
        {
            cout << str[i] << " ";
        }
        cout << '\n';
        return;
    }
    
    for (int i = 1; i < used.size(); ++i)
    {
        if (used[i] == false)
        {
            str += i + '0';
            used[i] = true;
            recur(str, depth + 1, goal, used);
            used[i] = false;
            str.pop_back();
        }
        
    }
}
