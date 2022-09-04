// 220903_BOJ_17822

#include <iostream>
#include <vector>

using namespace std;

int N, M, T, circle[51][51];
int pointer[51];
const int DEL = 987654321;

int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> T;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> circle[i][j];
        }
    }

    for (int t = 0; t < T; ++t)
    {
        int x, d, k;
        cin >> x >> d >> k;

        // x배수 원판 d방향 k칸 (d: 0시계, 1반시계)
        for (int i = x; i <= N; i += x)
        {
            if (d == 0)
            {
                pointer[i] = (pointer[i] - k + M) % M;
            }
            else
            {
                pointer[i] = (pointer[i] + k) % M;
            }
        }
        // for (int i = 1; i <= N; ++i)
        // {
        //     int p = pointer[i];
        //     for (int j = 0; j < M; ++j)
        //     {
        //         if (circle[i][(p + j) % M] == DEL)
        //         {
        //             cout << "X ";
        //         }
        //         else
        //         {
        //             cout << circle[i][(p + j) % M] << " ";
        //         }
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";

        // 인접
        vector<pair<int, int>> adj;
        int sum = 0, cnt = 0;
        for (int i = 1; i <= N; ++i)
        {
            int p = pointer[i];
            for (int j = 0; j < M; ++j)
            {
                int x = i, y = (j + p) % M;
                if (circle[x][y] == DEL)
                {
                    continue;
                }
                sum += circle[x][y];
                cnt++;
                bool flg = false;
                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k];
                    if (xx <= 0 || xx > N)
                    {
                        continue;
                    }
                    int yy = (pointer[xx] + (y - pointer[x] + M) % M + dy[k] + M) % M;
                    if (circle[x][y] == circle[xx][yy])
                    {
                        flg = true;
                        adj.push_back({xx, yy});
                    }
                }
                if (flg)
                {
                    adj.push_back({x, y});
                }
            }
        }

        if (adj.size() > 0)
        {
            for (pair<int, int> d : adj)
            {
                circle[d.first][d.second] = DEL;
            }
        }
        else
        {
            for (int i = 1; i <= N; ++i)
            {
                for (int j = 0; j < M; ++j)
                {
                    if (circle[i][j] == DEL)
                    {
                        continue;
                    }

                    if (circle[i][j] * cnt > sum)
                    {
                        circle[i][j]--;
                    }
                    else if (circle[i][j] * cnt < sum)
                    {
                        circle[i][j]++;
                    }
                }
            }
        }

        // for (int i = 1; i <= N; ++i)
        // {
        //     int p = pointer[i];
        //     for (int j = 0; j < M; ++j)
        //     {
        //         if (circle[i][(p + j) % M] == DEL)
        //         {
        //             cout << "X ";
        //         }
        //         else
        //         {
        //             cout << circle[i][(p + j) % M] << " ";
        //         }
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";
    }

    int ans = 0;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (circle[i][j] != DEL)
            {
                ans += circle[i][j];
            }
        }
    }
    cout << ans;

    return 0;
}
