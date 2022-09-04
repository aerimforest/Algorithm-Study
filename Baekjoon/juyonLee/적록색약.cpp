//10026

#include <iostream>
#include <queue>
#define MAX 101

int n, ans, ans2;
char arr[MAX][MAX];
bool visited[MAX][MAX];

int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};

using namespace std;

void bfs(int y, int x) 
{
    queue<pair<int, int>> q;
    visited[y][x] = true;

    q.push(make_pair(y, x));

    while(!q.empty())
    {
        auto cur = q.front(); 
        q.pop();

        for (int i = 0; i < 4; i++) 
        {
            int ny = cur.first + dy[i];
            int nx = cur.second + dx[i];
            
            if (0 <= ny && ny < n && 0 <= nx && nx < n) 
            {
                if (arr[ny][nx] != arr[y][x]) 
                    continue;

                if (visited[ny][nx]) 
                    continue;

                visited[ny][nx] = true;

                q.push(make_pair(ny, nx));
            }
        }
    }

}

int main() 
{

    cin >> n;

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++) 
        {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++) 
        {
            if (visited[i][j]) 
                continue;
            
            bfs(i, j);
            ans++;
        }
    }

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++) 
        {
            visited[i][j] = false;

            if (arr[i][j] == 'G') 
                arr[i][j] = 'R';
        }
    }

    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++) 
        {
            if (visited[i][j]) 
                continue;

            bfs(i, j);
            ans2++;
        }
    }

    cout << ans << ' ' << ans2;

    return 0;
}

//BFS, DFS