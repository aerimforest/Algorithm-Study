// [2206] 벽 부수고 이동하기
// dfs, dp
#include <iostream>
#include <vector>
#include <queue>   
using namespace std;

int n, m, visited[1001][1001][2]; // 0: 부숨, 1: 안부숨
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
string map[1001];
struct Info
{
    bool isBreakable;
    int x, y;
};

void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> map[i];
    }
}

int bfs()
{
    queue<Info> q;
    q.push({true, 0, 0});
    visited[0][0][1] = 1;

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        bool isBreakable = q.front().isBreakable;
        q.pop();
        if(x == n -1 && y == m - 1) {
            return visited[x][y][isBreakable];
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            
            if(map[nx][ny] == '0' && !visited[nx][ny][isBreakable]) {
                q.push({isBreakable, nx, ny});
                visited[nx][ny][isBreakable] = visited[x][y][isBreakable] + 1;
            }
            else if(map[nx][ny] == '1' && isBreakable) {
                q.push({false, nx, ny});
                visited[nx][ny][0] = visited[x][y][1] + 1;
            }
        }
    }
    return -1;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    cout << bfs() << '\n';

    return 0;
}