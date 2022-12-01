// [2589] 보물섬
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

bool visited[50][50];
int h, w, ans, path[50][50];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
string map[50];

void input()
{
    cin >> h >> w;
    for(int i = 0; i < h; i++) {
        cin >> map[i];
    }
}

int bfs(int sx, int sy)
{
    int cnt = 0;
    memset(visited, false, sizeof(visited));
    queue<pair<int, int>> q;

    visited[sx][sy] = true;
    q.push({sx, sy});

    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if(visited[nx][ny] || map[nx][ny] == 'W') continue;

            q.push({nx, ny});
            visited[nx][ny] = true;
            path[nx][ny] = path[x][y] + 1;
            ans = max(ans, path[nx][ny]);
        }
    }
    return cnt;
}

void solve()
{
    for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
            if(map[i][j] == 'L') {
                bfs(i, j);
            }
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
    cout << ans << '\n';

    return 0;
}