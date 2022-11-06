// 221106_BOJ_17472

#include <iostream>
#include <queue>

using namespace std;

int N, M, board[11][11];
int island[11][11], bridge[7][7];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};
const int INF = 987654321;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> board[i][j];
        }
    }

    // 1. 섬 찾기
    int cnt = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (board[i][j] == 1 && island[i][j] == 0)
            {
                queue<pair<int, int>> q;

                island[i][j] = ++cnt;
                q.push({i, j});
                while (!q.empty())
                {
                    int x = q.front().first, y = q.front().second;
                    q.pop();

                    for (int k = 0; k < 4; ++k)
                    {
                        int xx = x + dx[k], yy = y + dy[k];
                        if (xx < 0 || xx >= N || yy < 0 || yy >= M)
                        {
                            continue;
                        }

                        if (board[xx][yy] == 1 && island[xx][yy] == 0)
                        {
                            island[xx][yy] = cnt;
                            q.push({xx, yy});
                        }
                    }
                }
            }
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < M; ++j)
    //     {
    //         cout << island[i][j];
    //     }
    //     cout << "\n";
    // }

    // 2. 가능한 다리 찾기
    for (int i = 1; i <= cnt; ++i)
    {
        for (int j = 1; j <= cnt; ++j)
        {
            bridge[i][j] = INF;
        }
    }

    // 2-1. 가로 다리 찾기
    for (int i = 0; i < N; ++i)
    {
        int len = 0, A = 0, B = 0;
        for (int j = 0; j < M; ++j)
        {
            if (island[i][j] == 0)
            {
                len++;
            }
            else
            {
                B = island[i][j];
                bridge[A][B] = min(bridge[A][B], len);
                A = B;
            }
        }
    }
    // 2-2. 세로 다리 찾기

    return 0;
}
