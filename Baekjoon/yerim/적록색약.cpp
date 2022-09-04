// [10026] 적록색약
#include <iostream>
#include <cstring>
using namespace std;

int n, dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
bool visited[101][101];
char map[101][101], redGreenMap[101][101];

void input()
{
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> map[i][j];
            if(map[i][j] == 'G') redGreenMap[i][j] = 'R';
            else redGreenMap[i][j] = map[i][j];
        }
    }
}

void dfs(int x, int y, int type)
{
    visited[x][y] = true;
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if(visited[nx][ny] == true) continue;

        if(type == 1 && map[nx][ny] == map[x][y]) dfs(nx, ny, 1);
        else if(type == 2 && redGreenMap[nx][ny] == redGreenMap[x][y]) dfs(nx, ny, 2);
    }
}

int findRGBArea()
{
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(visited[i][j] == false) {
                dfs(i, j, 1);
                cnt++;
            }
        }
    }
    return cnt;
}

int findRBArea()
{
    int cnt = 0;
    memset(visited, false, sizeof(visited));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(visited[i][j] == false) {
                dfs(i, j, 2);
                cnt++;
            }
        }
    }
    return cnt;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    input();
    cout << findRGBArea() << ' ';
    cout << findRBArea() << '\n';

    return 0;
}