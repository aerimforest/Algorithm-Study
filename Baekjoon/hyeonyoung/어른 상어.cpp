// 220927_BOJ_19237

#include <iostream>
#include <cstring>

using namespace std;

int N, M, K;
pair<int, int> grid[21][21]; // 상어, 냄새
int priority[401][5][5];

struct shark
{
    int x, y, d;
};
shark sharks[2][401];

int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            int x;
            cin >> x;
            if (x > 0)
            {
                grid[i][j] = {x, K};
                sharks[0][x] = {i, j, 0};
            }
        }
    }
    for (int i = 1; i <= M; ++i)
    {
        int d;
        cin >> d;
        sharks[0][i].d = d;
    }
    for (int i = 1; i <= M; ++i)
    {
        for (int j = 1; j <= 4; ++j)
        {
            for (int k = 1; k <= 4; ++k)
            {
                cin >> priority[i][j][k];
            }
        }
    }

    int ans = -1;
    for (int T = 1; T <= 1000; ++T)
    {
        bool flg = !(T & 1);
        memset(sharks[!flg], 0, sizeof(sharks[!flg]));

        // 상어 이동
        for (int s = 1; s <= M; ++s)
        {
            int x = sharks[flg][s].x, y = sharks[flg][s].y, d = sharks[flg][s].d;
            if (d == -1)
            {
                continue;
            }

            // 냄새 없는 칸
            for (int k = 1; k <= 4; ++k)
            {
                int dd = priority[s][d][k];
                int xx = x + dx[dd], yy = y + dy[dd];

                if (xx <= 0 || xx > N || yy <= 0 || yy > N)
                {
                    continue;
                }

                if (grid[xx][yy].second <= 0)
                {
                    sharks[!flg][s] = {xx, yy, dd};
                    break;
                }
            }

            // 자신의 냄새가 있는 칸
            if (sharks[!flg][s].d != 0)
            {
                continue;
            }
            for (int k = 1; k <= 4; ++k)
            {
                int dd = priority[s][d][k];
                int xx = x + dx[dd], yy = y + dy[dd];

                if (xx <= 0 || xx > N || yy <= 0 || yy > N)
                {
                    continue;
                }

                if (grid[xx][yy].first == s)
                {
                    sharks[!flg][s] = {xx, yy, dd};
                    break;
                }
            }
        }

        for (int i = 1; i <= N; ++i)
        {
            for (int j = 1; j <= N; ++j)
            {
                if (grid[i][j].second > 1)
                {
                    grid[i][j].second -= 1;
                }
                else if (grid[i][j].second == 1)
                {
                    grid[i][j] = {0, 0};
                }
            }
        }

        int cnt = 0;
        for (int s = 1; s <= M; ++s)
        {
            if (sharks[!flg][s].d == 0)
            {
                continue;
            }

            int x = sharks[!flg][s].x, y = sharks[!flg][s].y;
            if (grid[x][y].second > 0)
            {
                int tmp = grid[x][y].first;
                if (tmp > s)
                {
                    grid[x][y] = {s, K};
                    sharks[!flg][tmp].d = 0;
                }
                else if (tmp == s)
                {
                    cnt++;
                    grid[x][y] = {s, K};
                }
                else
                {
                    grid[x][y] = {tmp, K};
                    sharks[!flg][s].d = 0;
                }
            }
            else
            {
                grid[x][y] = {s, K};
                cnt++;
            }
        }

        // cout << T << " " << cnt << "\n";
        // for (int i = 1; i <= N; ++i)
        // {
        //     for (int j = 1; j <= N; ++j)
        //     {
        //         if (grid[i][j].second == K)
        //         {
        //             cout << "!";
        //         }
        //         cout << "(" << grid[i][j].first << " " << grid[i][j].second << ")\t";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";

        if (cnt == 1)
        {
            ans = T;
            break;
        }
    }

    cout << ans;

    return 0;
}
