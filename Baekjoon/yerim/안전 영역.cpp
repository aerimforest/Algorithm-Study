// [2468] 안전 영역
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

bool flooded[101][101], visited[101][101];
int n, minHeight = 101, maxHeight = 0, ans;
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
struct Info {
    int x;
    int y;
    int h;
    bool operator<(const Info &ref) const {
        return this->h > ref.h;
    }
};
priority_queue<Info> q;

void input()
{
    int height;
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> height;
            q.push({i, j, height});
            maxHeight = max(maxHeight, height);
            minHeight = min(minHeight, height);
        }
    }
}

void dfs(int x, int y)
{
    visited[x][y] = true;
    
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if(!visited[nx][ny] && !flooded[nx][ny]) {
            dfs(nx, ny);
        }
    }
}

int caculateArea()
{
    int area = 0;
    memset(visited, false, sizeof(visited));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(!visited[i][j] && !flooded[i][j]) {
                dfs(i, j);
                area++;
            }
        }
    }
    return area;
}

void solve()
{
    for(int height = minHeight - 1; height < maxHeight; height++) {
        while(q.top().h <= height) {
            flooded[q.top().x][q.top().y] = true;
            q.pop();
        }
        ans = max(ans, caculateArea());
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