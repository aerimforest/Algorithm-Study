// 220829_BOJ_17143

#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int R, C, M;

int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, 1, -1};
struct shark
{
    int r, c, s, d, z;
};
shark grid[102][102];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C >> M;
    for (int i = 0; i < M; ++i)
    {
        int r, c, s, d, z;
        cin >> r >> c >> s >> d >> z;

        grid[r][c] = {r, c, s, d, z};
    }

    int ans = 0;
    for (int c = 1; c <= C; ++c)
    {
        // 상어 잡기
        for (int r = 1; r <= R; ++r)
        {
            if (grid[r][c].z > 0)
            {
                ans += grid[r][c].z;
                grid[r][c] = {0, 0, 0, 0, 0};
                break;
            }
        }

        // 상어 이동
        vector<shark> memo;
        for (int i = 1; i <= R; ++i)
        {
            for (int j = 1; j <= C; ++j)
            {
                int s = grid[i][j].s, d = grid[i][j].d, z = grid[i][j].z;
                int xx = i + dx[d] * s, yy = j + dy[d] * s;

                xx %= (R - 1) * 2;
                yy %= (C - 1) * 2;

                if (xx <= 0)
                {
                    xx += (R - 1) * 2;
                }
                if (yy <= 0)
                {
                    yy += (C - 1) * 2;
                }

                if (xx > R)
                {
                    d = (d == 1 ? 2 : 1);
                    xx = 2 * R - xx;
                }
                if (yy > C)
                {
                    d = (d == 3 ? 4 : 3);
                    yy = 2 * C - yy;
                }

                memo.push_back({xx, yy, s, d, z});
            }
        }
        memset(grid, 0, sizeof(grid));
        for (shark m : memo)
        {
            if (grid[m.r][m.c].z < m.z)
            {
                grid[m.r][m.c] = m;
            }
        }

        // for (int i = 1; i <= R; ++i)
        // {
        //     for (int j = 1; j <= C; ++j)
        //     {
        //         cout << grid[i][j].z << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";
    }

    cout << ans;

    return 0;
}
