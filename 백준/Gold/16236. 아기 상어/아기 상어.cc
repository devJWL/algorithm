#include <bits/stdc++.h>


struct Baby{
    int y, x, size, eatCount;
};

struct Pray {
    int y, x, dist;
};

bool cmp (Pray & lhs, Pray & rhs){
    if (lhs.dist == rhs.dist){
        if (lhs.y == rhs.y){
            return lhs.x < rhs.x;
        }
        return lhs.y < rhs.y;
    }
    return lhs.dist < rhs.dist;
}


int map[20][20];
int dist[20][20];
int n;
Baby baby;



int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n;

    for (int i = 0; i < n; ++i){
        for (int j = 0; j < n; ++j){
            std::cin >> map[i][j];
            if (map[i][j] == 9){
                baby.y = i; baby.x = j;
                baby.size = 2; baby.eatCount = 0;
                map[i][j] = 0;
            }
        }
    }

    const int dy[] = {-1, 1, 0, 0};
    const int dx[] = {0, 0, -1, 1};
    int ret = 0;
    bool flag = true;
    
    while(flag){
        flag = false;
        std::queue<std::pair<int, int>> q;
        std::vector<Pray> prays;

        for (int i = 0; i < n; ++i){
            std::fill(dist[i], dist[i] + n, -1);
        }

        q.push({baby.y, baby.x});
        dist[baby.y][baby.x] = 0;

        while(!q.empty()){
            auto [y, x] = q.front(); q.pop();
            for (int dir = 0; dir < 4; ++dir){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (map[ny][nx] > baby.size) continue;
                if (dist[ny][nx] != -1) continue;

                q.push({ny, nx});
                dist[ny][nx] = dist[y][x] + 1;
                if (map[ny][nx] != 0 && map[ny][nx] < baby.size){
                    prays.push_back({ny, nx, dist[ny][nx]});
                }
            }
        }

        if (prays.size() == 0) break;
        flag = true;
        std::sort(prays.begin(), prays.end(), cmp);

        ret += prays[0].dist;   
        baby.y = prays[0].y;
        baby.x = prays[0].x;
        map[baby.y][baby.x] = 0;
        ++baby.eatCount;
        if (baby.size == baby.eatCount){
            ++baby.size;
            baby.eatCount = 0;
        }
    }

    std::cout << ret << '\n';

    return 0;
}