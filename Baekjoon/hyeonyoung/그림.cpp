// 221212_BOJ_1926

#include <iostream>
#include <queue>

using namespace std;

int N, M;
bool paper[501][501], visit[501][501];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs(int i, int j)
{
    int ret = 0;
    queue<pair<int, int>> q;
    visit[i][j] = 1;
    q.push({i, j});

    while (!q.empty())
    {
        int x = q.front().first, y = q.front().second;
        q.pop();
        ret++;

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }
            if (paper[xx][yy] && !visit[xx][yy])
            {
                visit[xx][yy] = 1;
                q.push({xx, yy});
            }
        }
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> paper[i][j];
        }
    }

    int cnt = 0, max_size = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (paper[i][j] && !visit[i][j])
            {
                cnt++;
                max_size = max(max_size, bfs(i, j));
            }
        }
    }
    cout << cnt << "\n"
         << max_size << "\n";

    return 0;
}
