// [20208] 진우의 민트초코우유
#include <iostream>
#include <queue>
#include <cmath>
using namespace std;

bool visited[11];
int n, m, h, ans, homeX, homeY;
deque<pair<int, int>> milk;

void input()
{
    int map[11][11];
    cin >> n >> m >> h;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> map[i][j];
            if(map[i][j] == 1) {
                homeX = i; homeY = j;
            }
            else if(map[i][j] == 2) {
                milk.push_back(make_pair(i, j));
            }
        }
    }
}

void getMilk(int sx, int sy, int milkNum, int power)
{
    if(power <= 0) return;
    if(abs(sx - homeX) + abs(sy - homeY) <= power) { // 현재 체력으로 집에 돌아갈 수 있음
        ans = max(ans, milkNum);
    }
    // 순열
    for(int i = 0; i < milk.size(); i++) {
        int dist = abs(sx - milk[i].first) + abs(sy - milk[i].second);
        if(dist <= power && visited[i] == false) {
            visited[i] = true;
            getMilk(milk[i].first, milk[i].second, milkNum + 1, power + h - dist);
            visited[i] = false;
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    getMilk(homeX, homeY, 0, m);
    cout << ans << '\n';

    return 0;
}