// [3055] 탈출
#include <iostream>
#include <queue>
using namespace std;

bool isArrive, visited[51][51];
char map[51][51];
int r, c, ans, dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
struct Info {
    int x;
    int y;
    int time;
};
queue<Info> path;
queue<pair<int, int>> water;

void input()
{
    cin >> r >> c;
    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            cin >> map[i][j];
            if(map[i][j] == '*') water.push(make_pair(i, j));
            else if(map[i][j] == 'S') {
                path.push({i, j, 0});
                visited[i][j] = true;
            }
        }
    }
}

void moveWater()
{   
    int initWater = water.size();
    for(int i = 0; i < initWater; i++) {
        int x = water.front().first;
        int y = water.front().second;
        water.pop();
        for(int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if(map[nx][ny] == '.') {
                map[nx][ny] = '*';
                water.push(make_pair(nx, ny));
            }
        }
    }
}

void moveHedgehog()
{
    int initPathSize = path.size();
    if(initPathSize == 0) {
        cout << "KAKTUS\n";
        exit(0);
    }
    for(int i = 0; i < initPathSize; i++) {
        int x = path.front().x;
        int y = path.front().y;
        int time = path.front().time;
        path.pop();
        for(int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            else if(map[nx][ny] == 'D') { // 비버 굴 도착
                isArrive = true;
                ans = time + 1;
                return;
            }
            else if(map[nx][ny] == '.' && visited[nx][ny] == false) {
                path.push({nx, ny, time + 1});
                visited[nx][ny] = true;
                map[x][y] = '.'; // 고슴도치 이동하고 나면 그 전에 있었던 자리는 빈칸 처리
            }
        }
    }
}

void solve()
{
    while(isArrive == false) {
        moveWater();
        moveHedgehog();
    }
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}