// [1261] 알고스팟
#include <iostream>
#include <queue>
#define INF 10500
using namespace std;

int n, m, dist[101][101];
int dx[4] = { 0, 0, 1, -1 }, dy[4] = { 1, -1, 0, 0 };
char maze[101][101];

void input()
{
    cin >> m >> n;
    for(int i = 1 ; i <= n ; i++) {
        for(int j = 1 ; j <= m ; j++) {
            cin >> maze[i][j];
        }
    }
}

void move(int n, int m, int x, int y)
{
    queue<pair<int, int> >q;
    q.push(make_pair(x, y));
    dist[x][y] = 0;
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                if(maze[x][y] == '1') {
                    if(dist[nx][ny] > dist[x][y] + 1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.push(make_pair(nx, ny));
                    }
                }
                else {
                    if(dist[nx][ny] > dist[x][y]) {
                        dist[nx][ny] = dist[x][y];
                        q.push(make_pair(nx, ny));
                    }
                }
            }
        }
    }
}

void initialize()
{
    for(int i = 1 ; i <= n ; i++) {
        for(int j = 1 ; j <= m ; j++) {
            dist[i][j] = INF;
        }
    }
}

int main(void)
{
    cin.tie(NULL); 
    ios_base::sync_with_stdio(false);
    
    input();
    initialize();
    move(n, m, 1, 1);
    cout << dist[n][m] << '\n';

    return 0;
}