#include <bits/stdc++.h>

bool solution(std::string s){
    int count = 0;

    for (char & ch : s){
        ch = (char)std::tolower(ch);
    }

    for (const char ch : s) {
        if (ch == 'p') {
            ++count;
        }
        else if (ch == 'y'){
            --count;
        }
    }

    return count == 0;
}