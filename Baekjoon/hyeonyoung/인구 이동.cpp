// 221110_BOJ_16234

#include <iostream>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

int N, L, R, A[51][51];
int visit[51][51];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L >> R;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> A[i][j];
        }
    }

    int answer;
    for (answer = 0;; answer++)
    {
        int country = 0;
        memset(visit, 0, sizeof(visit));
        vector<pair<int, int>> change; // cnt, sum
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if (visit[i][j])
                {
                    continue;
                }

                int cnt = 0, sum = 0;
                queue<pair<int, int>> q;
                visit[i][j] = ++country;
                q.push({i, j});
                while (!q.empty())
                {
                    int x = q.front().first, y = q.front().second;
                    q.pop();

                    cnt++;
                    sum += A[x][y];

                    for (int k = 0; k < 4; ++k)
                    {
                        int xx = x + dx[k], yy = y + dy[k];
                        if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                        {
                            continue;
                        }

                        int dif = abs(A[x][y] - A[xx][yy]);
                        if (dif >= L && dif <= R && visit[xx][yy] == 0)
                        {
                            visit[xx][yy] = visit[x][y];
                            q.push({xx, yy});
                        }
                    }
                }

                change.push_back({cnt, sum});
            }
        }

        bool mov = false;
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                int cnt = change[visit[i][j] - 1].first;
                int sum = change[visit[i][j] - 1].second;
                if (A[i][j] != sum / cnt)
                {
                    A[i][j] = sum / cnt;
                    mov = true;
                }
            }
        }

        if (!mov)
        {
            break;
        }

        // for (int i = 0; i < N; ++i)
        // {
        //     for (int j = 0; j < N; ++j)
        //     {
        //         cout << A[i][j] << " ";
        //     }
        //     cout << "\n";
        // }
    }

    cout << answer;

    return 0;
}
