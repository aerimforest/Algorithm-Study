// [2206] 벽 부수고 이동하기
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#define INF 987654321
using namespace std;

bool visited[10001][1001];
int n, m, ans = INF;
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
string map[1001];
struct Info
{
    int x, y, cnt;
};


void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> map[i];
    }
}

void bfs()
{
    memset(visited, false, sizeof(visited));

    queue<Info> q;
    q.push({0, 0, 1});
    visited[1][1] = true;

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int cnt = q.front().cnt;
        q.pop();
        if(x == n -1 && y == m - 1) {
            ans = min(ans, cnt);
            cout << "ans = " << ans << '\n';
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(!visited[nx][ny] && map[nx][ny] == '0') {
                q.push({nx, ny, cnt + 1});
                visited[nx][ny] = true;
            }
        }
    }
}

void solve()
{
    bfs();
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(map[i][j] == '1') {
                map[i][j] = '0';
                bfs();
                map[i][j] = '1';
            }
        }
    }
    if(ans == INF) cout << "-1\n";
    else cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}