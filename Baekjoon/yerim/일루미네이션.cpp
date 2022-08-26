// [5547] 일루미네이션
// bfs
#include <iostream>
#include <queue>
using namespace std;

bool visited[101][101];
int w, h, map[101][101];
int dx[2][6] = {{0, -1, -1, -1, 0, 1}, {0, -1, 0, 1, 1, 1}}, dy[2][6] = {{-1, -1, 0, 1, 1, 0}, {-1, 0, 1, 1, 0, -1}};

void input()
{
    cin >> w >> h;
    for(int i = 1; i <= h; i++) {
        for(int j = 1; j <= w; j++){
            cin >> map[i][j];
        }
    }
}

void bfs(int y, int x)
{
    queue<pair<int, int>> q;
    q.push(make_pair(y, x));
    map[y][x] = 2;
    visited[y][x] = true;

    while(!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i = 0; i < 6; i++) {
            int nx, ny;
            if(y % 2 == 0) {
                nx = x + dx[0][i];
                ny = y + dy[0][i];
            }
            else {
                nx = x + dx[1][i];
                ny = y + dy[1][i];
            }
            if(nx < 1 || nx > w || ny < 1 || ny > h) continue;
            if(visited[ny][nx] == false && map[ny][nx] == 0) {
                map[ny][nx] = 2;
                visited[ny][nx] = true;
                q.push(make_pair(ny, nx));
            }
        }
    }
}

void findOuterSpace()
{
    for(int i = 1; i <= w; i++) {
        if(visited[1][i] == false && map[1][i] == 0) bfs(1, i);
        if(visited[h][i] == false && map[h][i] == 0) bfs(h, i);
    }
    for(int i = 1; i <= h; i++) {
        if(visited[i][1] == false && map[i][1] == 0) bfs(i, 1);
        if(visited[i][w] == false && map[i][w] == 0) bfs(i, w);
    }
}

int decoWall()
{
    int ans = 0;
    // 내부
    for(int y = 1; y <= h; y++) {
        for(int x = 1; x <= w; x++) {
            if(map[y][x] == 2) {
                int wall = 0;
                for(int k = 0; k < 6; k++) {
                    int nx, ny;
                    if(y % 2 == 0) {
                        nx = x + dx[0][k];
                        ny = y + dy[0][k];
                    }
                    else {
                        nx = x + dx[1][k];
                        ny = y + dy[1][k];
                    }
                    if(nx < 1 || nx > w || ny < 1 || ny > h) continue;
                    if(map[ny][nx] == 1) wall++;
                }
                ans += wall;
            }
        }
    }
    // 제일 윗줄 & 아랫줄
    for(int x = 1; x <= w; x++) {
        if(map[1][x] == 1) ans += 2;
        if(map[h][x] == 1) ans += 2;
    }
    // 제일 왼쪽줄 & 오른쪽줄
    for(int y = 1; y <= h; y++) {
        if(map[y][1] == 1) {
            if(y % 2 == 0) ans += 3;
            else ans += 1;
        }
        if(map[y][w] == 1) {
            if(y % 2 == 0) ans += 1;
            else ans += 3;
        }
    }
    if(map[1][w] == 1) ans--; 
    if(h % 2 == 0 && map[h][1] == 1) ans--; 
    if(h % 2 != 0 && map[h][w] == 1) ans--;
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    findOuterSpace();
    cout << decoWall() << '\n';

    return 0;    
}