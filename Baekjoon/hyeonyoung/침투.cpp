// 221107_BOJ_13565

#include <iostream>
#include <queue>

using namespace std;

int M, N;
char grid[1001][1001];
bool visit[1001][1001], answer = false;
queue<pair<int, int>> q;

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> grid[i];
    }

    for (int j = 0; j < M; ++j)
    {
        if (grid[0][j] == '0')
        {
            visit[0][j] = true;
            q.push({0, j});
        }
    }

    while (!q.empty())
    {
        int x = q.front().first, y = q.front().second;
        q.pop();

        if (x == N - 1)
        {
            answer = true;
            break;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }
            if (grid[xx][yy] == '0' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = 1;
                q.push({xx, yy});
            }
        }
    }
    if (answer)
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }

    return 0;
}
