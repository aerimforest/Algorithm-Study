// [2638] 치즈
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

bool visited[102][102];
int n, m, ans, board[102][102];
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};

void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }
}

bool check(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j]) return false; 
        }
    }
    return true; 
}
void bfs(){
    queue<pair<int,int>> q;
    int boardCopy[n][m];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            boardCopy[i][j] = board[i][j];
        }
    }

    memset(visited,0,sizeof(visited));
    ans++;
    q.push({0, 0});
    visited[0][0] = 1;

    while(!q.empty()){
        auto cur = q.front(); q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny]) continue;

            if(board[nx][ny]) board[nx][ny]++; 
            if(board[nx][ny] == 0){
                q.push({nx, ny});
                visited[nx][ny] = 1;
            }
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j] - 1 >= 2) boardCopy[i][j] = 0;
            board[i][j] = boardCopy[i][j];
        }
    }
}

void solve()
{
    while(!check()) {
        bfs();
    }
    cout << ans << '\n';
}

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}