// [17070] 파이프 옮기기 1
#include <iostream>
#include <queue>
using namespace std;

int n, ans, map[17][17];
int dx[3] = {0, 1, 1}, dy[3] = {1, 0, 1};
struct Info
{
    // state -> 0: 가로, 1: 세로, 2: 대각선
    int x, y, state;
};
queue<Info> q;

void input()
{
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            cin >> map[i][j];
        }
    }
}

void check(int x, int y, int dir)
{
    // 역방향(위, 왼쩍) 이동 없이 전진만 하기 떄문에 visited 필요 없음
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if(nx < 1 || nx > n || ny < 1 || ny > n) return;
    if(map[nx][ny] == 0) {
        if(dir == 2) { // 대각선인 경우
            if(map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1) {
                return;
            }
        }
        q.push({nx, ny, dir});
    }
}

void solve()
{
    q.push({1, 2, 0});

    while(!q.empty()) {
        Info cur = q.front();
        q.pop();
        if(cur.x == n && cur.y == n) {
            ans++;
            continue;
        }
        if(cur.state == 0 || cur.state == 1) { // 가로 or 세로
            check(cur.x, cur.y, cur.state); 
            check(cur.x, cur.y, 2);
        }   
        else { // 대각선
            for(int i = 0; i < 3; i++) {
                check(cur.x, cur.y, i);
            }
        }
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