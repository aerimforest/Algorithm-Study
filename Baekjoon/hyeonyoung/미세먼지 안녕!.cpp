// 220903_BOJ_17144

#include <iostream>
#include <cstring>

using namespace std;

int R, C, T, A[51][51];
int dust = 0, air;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C >> T;
    for (int i = 0; i < R; ++i)
    {
        for (int j = 0; j < C; ++j)
        {
            cin >> A[i][j];
            if (A[i][j] == -1)
            {
                air = i;
            }
            else
            {
                dust += A[i][j];
            }
        }
    }

    for (int t = 0; t < T; ++t)
    {
        // 미세먼지 확산
        int tmp[51][51];
        memset(tmp, 0, sizeof(tmp));

        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                if (A[i][j] <= 0)
                {
                    continue;
                }

                int dif = A[i][j] / 5;
                for (int k = 0; k < 4; ++k)
                {
                    int ii = i + dx[k], jj = j + dy[k];
                    if (ii < 0 || ii >= R || jj < 0 || jj >= C || A[ii][jj] == -1)
                    {
                        continue;
                    }

                    tmp[ii][jj] += dif;
                    A[i][j] -= dif;
                }
                tmp[i][j] += A[i][j];
            }
        }
        tmp[air - 1][0] = tmp[air][0] = -1;
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                A[i][j] = tmp[i][j];
            }
        }

        // cout << t << "\n";
        // for (int i = 0; i < R; ++i)
        // {
        //     for (int j = 0; j < C; ++j)
        //     {
        //         cout << A[i][j] << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";

        // 공기청정기 작동
        // 위쪽
        int x = air - 1, y = 0;
        dust -= A[x - 1][y];
        for (int i = x - 1; i - 1 >= 0; --i)
        {
            A[i][y] = A[i - 1][y];
        }
        for (int j = 0; j + 1 < C; ++j)
        {
            A[0][j] = A[0][j + 1];
        }
        for (int i = 0; i + 1 <= x; ++i)
        {
            A[i][C - 1] = A[i + 1][C - 1];
        }
        for (int j = C - 1; j - 1 > 0; --j)
        {
            A[x][j] = A[x][j - 1];
        }
        A[x][y + 1] = 0;

        // 아래쪽
        x = air, y = 0;
        dust -= A[x + 1][y];
        for (int i = x + 1; i + 1 < R; ++i)
        {
            A[i][y] = A[i + 1][y];
        }
        for (int j = 0; j + 1 < C; ++j)
        {
            A[R - 1][j] = A[R - 1][j + 1];
        }
        for (int i = R - 1; i - 1 >= x; --i)
        {
            A[i][C - 1] = A[i - 1][C - 1];
        }
        for (int j = C - 1; j - 1 > 0; --j)
        {
            A[x][j] = A[x][j - 1];
        }
        A[x][y + 1] = 0;

        // cout << t << "\n";
        // for (int i = 0; i < R; ++i)
        // {
        //     for (int j = 0; j < C; ++j)
        //     {
        //         cout << A[i][j] << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";
    }

    cout << dust;

    return 0;
}
