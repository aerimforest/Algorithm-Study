// 221106_BOJ_17472

#include <iostream>
#include <queue>

using namespace std;

int N, M, board[11][11], answer = 0;
int island[11][11], bridge[11][11];
bool connect[11];

struct state
{
    int A, B, br;

    bool operator<(const state &X) const
    {
        return this->br > X.br;
    }
};

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
                            island[xx][yy] = island[x][y];
                            q.push({xx, yy});
                        }
                    }
                }
            }
        }
    }

    // cout << "\n";
    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < M; ++j)
    //     {
    //         cout << island[i][j] << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";

    // 2. 가능한 다리 찾기
    for (int i = 0; i <= cnt; ++i)
    {
        for (int j = 0; j <= cnt; ++j)
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
            else if (len <= 1)
            {
                len = 0;
                A = island[i][j];
            }
            else
            {
                B = island[i][j];
                bridge[A][B] = bridge[B][A] = min(bridge[A][B], len);
                A = B;
                len = 0;
            }
        }
    }

    // 2-2. 세로 다리 찾기
    for (int j = 0; j < M; ++j)
    {
        int len = 0, A = 0, B = 0;
        for (int i = 0; i < N; ++i)
        {
            if (island[i][j] == 0)
            {
                len++;
            }
            else if (len <= 1)
            {
                len = 0;
                A = island[i][j];
            }
            else
            {
                B = island[i][j];
                bridge[A][B] = bridge[B][A] = min(bridge[A][B], len);
                A = B;
                len = 0;
            }
        }
    }

    // for (int i = 1; i <= cnt; ++i)
    // {
    //     for (int j = 1; j <= cnt; ++j)
    //     {
    //         if (bridge[i][j] == INF)
    //         {
    //             cout << "- ";
    //         }
    //         else
    //         {
    //             cout << bridge[i][j] << " ";
    //         }
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";

    // 3. 다리 연결하기
    int bridge_cnt = 0;
    priority_queue<state> pq;
    connect[1] = 1;
    for (int i = 1; i <= cnt; ++i)
    {
        if (bridge[1][i] < INF)
        {
            pq.push({1, i, bridge[1][i]});
        }
    }
    while (!pq.empty() && bridge_cnt < cnt - 1)
    {
        int A = pq.top().A, B = pq.top().B, len = pq.top().br;
        pq.pop();

        if (connect[A] && connect[B])
        {
            continue;
        }

        if (!connect[B])
        {
            swap(A, B);
        }

        // B에 A를 추가
        connect[A] = 1;
        for (int i = 1; i <= cnt; ++i)
        {
            if (connect[i] == false && bridge[A][i] < INF)
            {
                pq.push({A, i, bridge[A][i]});
            }
        }

        // cout << A << " " << B << " " << bridge[A][B] << "\n";
        answer += len;
        bridge_cnt++;
    }
    if (bridge_cnt < cnt - 1)
    {
        answer = -1;
    }
    cout << answer;

    return 0;
}
