// [17144] 미세먼지 안녕!
#include <iostream>
#include <queue>
#include <cstring>
#include <vector>
#include <cstdio>
using namespace std;

int R, C, T, map[51][51], tmpMap[51][51];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
queue<pair<int, int>> dusts;
vector<pair<int, int>> cleaner;

void input()
{
    cin >> R >> C >> T;
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cin >> map[i][j];
            if(map[i][j] == -1) cleaner.push_back(make_pair(i, j));
        }
    }
}

void spreadDust()
{
    memset(tmpMap, 0, sizeof(tmpMap));
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            if(map[i][j] > 0) dusts.push(make_pair(i, j));
        }
    }

    while(!dusts.empty()) {
        int x = dusts.front().first;
        int y = dusts.front().second;
        int cnt = 0;
        dusts.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 1 || nx > R || ny < 1 || ny > C) continue;
            if(map[nx][ny] == -1) continue;
            cnt++;
            tmpMap[nx][ny] += map[x][y] / 5;
        }
        tmpMap[x][y] += -1 * (map[x][y] / 5) * cnt;
    }
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            map[i][j] += tmpMap[i][j];
        }
    }
    cout << "\n먼지 확산\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << map[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';
}

void clean(int x, int y, int length, int dir)
{
    int nx = x, ny = y; 
    for(int i = 0; i < length - 1; i++) {
        nx += dx[dir];
        ny += dy[dir];
        //printf("\nnx = %d, ny = %d\n", nx, ny);
        if(map[nx][ny] > 0) {
            int nnx = nx + dx[dir];
            int nny = ny + dy[dir];
            //printf("nnx = %d, nny = %d\n", nnx, nny);
            tmpMap[nnx][nny] = map[nx][ny];
            map[nx][ny] = 0;
            //printf("tmpMap[%d][%d] = %d\n", nnx, nny, tmpMap[nnx][nny]);
        }
    }
}

void startCleaner()
{
    memset(tmpMap, 0, sizeof(tmpMap));
    // 위쪽 공기청정기
    clean(cleaner[0].first, 1, C - 1, 1);
    if(map[cleaner[0].first][C] > 0) {
        tmpMap[cleaner[0].first - 1][C] = map[cleaner[0].first][C];
        map[cleaner[0].first][C] = 0;
    }

    cout << "\n위쪽 ->\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';

    clean(cleaner[0].first, C, cleaner[0].first - 1, 0);
    if(map[1][C] > 0) {
        tmpMap[1][C - 1] = map[1][C];
        map[1][C] = 0;
    }

    cout << "\n위쪽 ^\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';

    clean(1, C, C - 1, 3);
    if(map[1][1] > 0) {
        tmpMap[2][1] = map[1][1];
        map[1][1] = 0;
    }

    cout << "\n위쪽 <-\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';

    clean(1, 1, cleaner[0].first - 1, 2);
    map[cleaner[0].first - 1][1] = 0;

    // 아래쪽 공기청정기
    clean(cleaner[1].first, 1, C - 1, 1);
    if(map[cleaner[1].first][C] > 0) {
        tmpMap[cleaner[1].first + 1][C] = map[cleaner[1].first][C];
        map[cleaner[1].first][C] = 0;
    }

    cout << "\n아래쪽 ->\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';
    
    clean(cleaner[1].first, C, R - cleaner[1].first, 2);
    if(map[R][C] > 0) {
        tmpMap[R][C - 1] = map[R][C];
        map[R][C] = 0;
    }

    cout << "\n아래쪽 down\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';
    
    clean(R, C, C - 1, 3);
    if(map[R][1] > 0) {
        tmpMap[R - 1][1] = map[R][1];
        map[R][1] = 0;
    }

    cout << "\n아래쪽 <-\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';
    
    clean(R, 1, R - cleaner[1].first, 0);
    map[cleaner[1].first + 1][1] = 0;
    cout << "\n아래쪽 ^\n";
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << tmpMap[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';

    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            if(tmpMap[i][j] > 0) map[i][j] = tmpMap[i][j];
        }
    }
}

void getLeftDust()
{
    cout << "result\n";
    int ans = 0;
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            cout << map[i][j] << " ";
            if(map[i][j] > 0) ans += map[i][j];
        }
        cout << '\n';
    }
    cout << '\n';
    cout << ans << '\n';
}

void solve()
{
    int time = 1;
    while(time <= T) {
        time++;
        spreadDust();
        startCleaner();
    }
    getLeftDust();
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}