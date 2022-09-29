// [2178] 미로 탐색
#include <iostream>
#include <queue>
using namespace std;

int n, m;
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
bool visited[101][101];
string map[101];
struct Info {
    int x;
    int y;
    int cnt;
};

void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> map[i];
    }
}

void bfs(int sx, int sy, int initCnt)
{
    queue<Info> q;
    q.push({sx, sy, initCnt});
    visited[sx][sy] = true;

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int cnt = q.front().cnt;
        q.pop();

        if(x == n - 1 && y == m - 1) {
            cout << cnt << '\n';
            break;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(map[nx][ny] == '1' && visited[nx][ny] == false) {
                visited[nx][ny] = true;
                q.push({nx, ny, cnt + 1});
            }
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    bfs(0, 0, 1);

    return 0;
}