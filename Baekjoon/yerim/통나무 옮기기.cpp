// [1938] 통나무 옮기기
#include <iostream>
#include <string>
#include <queue>
#include <vector>
#include <tuple>
using namespace std;

struct Info {
    int x, y, d, cnt;
};

bool visited[51][51][2]; // 가로, 세로
char map[51][51];
int n, ans = -1, dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};
vector<pair<int, int>> B, E;

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < s.size(); j++) {
            map[i][j] = s[j];
            if (s[j] == 'B') {
                map[i][j] = '0';
                B.push_back(make_pair(i, j));
            }
            if (s[j] == 'E') {
                map[i][j] = '0';
                E.push_back(make_pair(i, j));
            }
        }
    }
}
 
bool check(int nx, int ny, int z) 
{
    if (visited[nx][ny][z]) {
        return false;
    }
    if (z == 0) {
        if (nx >= 0 && nx < n && ny-1 >= 0 && ny+1 < n) {
            if (map[nx][ny-1] == '0' && map[nx][ny] == '0' && map[nx][ny+1] == '0') {
                return true;
            }
        }
    }
    else if (z == 1) {
        if (nx-1 >= 0 && nx+1 < n && ny >= 0 && ny < n) {
            if (map[nx-1][ny] == '0' && map[nx][ny] == '0' && map[nx+1][ny] == '0') {
                return true;
            }
        }
    }
    return false;
}

void bfs(int shapeB, int shapeE)
{
    queue<Info> q;
    q.push({B[1].first, B[1].second, shapeB, 0});
    visited[B[1].first][B[1].second][shapeB] = true;
 
    while (!q.empty()) {
        Info cur = q.front();
        q.pop();
        if (E[1].first == cur.x && E[1].second == cur.y && shapeE == cur.d) {
            ans = cur.cnt;
        }
        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            if (cur.d == 0) {
                if (check(nx, ny, cur.d)) {
                    visited[nx][ny][cur.d] = true;
                    q.push({nx, ny, cur.d, cur.cnt + 1});
                }
            }
            else if (cur.d == 1) {
                if (check(nx, ny, cur.d)) {
                    visited[nx][ny][cur.d] = true;
                    q.push({nx, ny, cur.d, cur.cnt + 1});
                }
            }
        }
        bool flag = false;
        if (cur.x-1 >= 0 && cur.x+1 < n && cur.y-1 >= 0 && cur.y+1 < n) {
            for (int i = cur.x-1; i < cur.x+2; i++) {
                for (int j = cur.y-1; j < cur.y+2; j++) {
                    if (map[i][j] == '1') flag = true;
                }
            }
        }
        if (flag == true) continue;
        if (cur.d == 0) {
            if (check(cur.x, cur.y, 1)) {
                visited[cur.x][cur.y][1] = true;
                q.push({cur.x, cur.y, 1, cur.cnt + 1});
            }
        }
        else if (cur.d == 1) {
            if (check(cur.x, cur.y, 0)) {
                visited[cur.x][cur.y][0] = true;
                q.push({cur.x, cur.y, 0, cur.cnt + 1});
            }
        }
    }
}

void solve()
{
    int shapeB, shapeE; // 0: 가로, 1: 세로
    if (B[0].first == B[1].first && B[0].first == B[2].first) {
        shapeB = 0;
    }
    if (B[0].second == B[1].second && B[0].second == B[2].second) {
        shapeB = 1;
    }
    if (E[0].first == E[1].first && E[0].first == E[2].first) {
        shapeE = 0;
    }
    if (E[0].second == E[1].second && E[0].second == E[2].second) {
        shapeE = 1;
    }
 
    bfs(shapeB, shapeE);

    if (ans == -1) cout << "0\n";
    else cout << ans << "\n";
}
 
int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
 
    return 0;
}
