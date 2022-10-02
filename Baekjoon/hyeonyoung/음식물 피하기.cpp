// 220930_BOJ_1743

#include <iostream>
#include <queue>

using namespace std;

int N, M, K;
bool board[101][101], visit[101][101];
queue<pair<int, int>> Q;
int ans = 0;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int k = 0; k < K; ++k)
    {
        int r, c;
        cin >> r >> c;
        board[r][c] = 1;
    }

    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= M; ++j)
        {
            if (board[i][j] && !visit[i][j])
            {
                int cnt = 0;
                visit[i][j] = 1;
                Q.push({i, j});

                while (!Q.empty())
                {
                    int x = Q.front().first, y = Q.front().second;
                    Q.pop();

                    cnt++;
                    for (int k = 0; k < 4; ++k)
                    {
                        int xx = x + dx[k], yy = y + dy[k];
                        if (xx <= 0 || xx > N || yy <= 0 || yy > M)
                        {
                            continue;
                        }
                        if (board[xx][yy] && !visit[xx][yy])
                        {
                            visit[xx][yy] = 1;
                            Q.push({xx, yy});
                        }
                    }
                }
                ans = max(ans, cnt);
            }
        }
    }

    cout << ans;

    return 0;
}
