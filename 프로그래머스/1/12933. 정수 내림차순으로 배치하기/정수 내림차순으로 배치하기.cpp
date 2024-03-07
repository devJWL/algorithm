#include <bits/stdc++.h>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    int cnt[10] = {0,};
    while(n != 0){
        ++cnt[n % 10];
        n /= 10;
    }
    
    for (int i = 9; i >= 0; --i){
        while(cnt[i] != 0){
            answer = answer * 10 + i;
            --cnt[i];
        }
    }
    return answer;
}