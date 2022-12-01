// 221201_BOJ_2589

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, M, answer = 0;
char board[51][51];
int visit[51][51];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

int bfs(int i, int j)
{
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> q;

    int ret = 0;

    visit[i][j] = 1;
    q.push({i, j});
    while (!q.empty())
    {
        int x = q.front().first, y = q.front().second;
        q.pop();

        ret = max(ret, visit[x][y]);
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }
            if (board[xx][yy] == 'L' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                q.push({xx, yy});
            }
        }
    }

    return ret - 1;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (board[i][j] == 'L')
            {
                answer = max(answer, bfs(i, j));
            }
        }
    }
    cout << answer;

    return 0;
}
