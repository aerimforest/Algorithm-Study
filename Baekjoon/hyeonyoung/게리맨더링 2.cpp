// 220919_BOJ_17779

#include <iostream>
#include <cstring>

using namespace std;

int N, A[22][22];
bool edge[22][22];
int total = 0, ans = 987654321;

int solve(int x, int y, int d1, int d2)
{
    // 경계
    memset(edge, false, sizeof(edge));
    for (int i = 0; i <= d1; ++i)
    {
        edge[x + i][y - i] = true;
        edge[x + d2 + i][y + d2 - i] = true;
    }
    for (int i = 0; i <= d2; ++i)
    {
        edge[x + i][y + i] = true;
        edge[x + d1 + i][y - d1 + i] = true;
    }

    int P[6] = {0, 0, 0, 0, 0, 0};
    // 1
    for (int i = 1; i < x + d1; ++i)
    {
        for (int j = 1; j <= y; ++j)
        {
            if (edge[i][j])
            {
                break;
            }
            P[1] += A[i][j];
        }
    }
    // 2
    for (int i = 1; i <= x + d2; ++i)
    {
        for (int j = N; j > y; --j)
        {
            if (edge[i][j])
            {
                break;
            }
            P[2] += A[i][j];
        }
    }
    // 3
    for (int i = x + d1; i <= N; ++i)
    {
        for (int j = 1; j < y - d1 + d2; ++j)
        {
            if (edge[i][j])
            {
                break;
            }
            P[3] += A[i][j];
        }
    }
    // 4
    for (int i = x + d2 + 1; i <= N; ++i)
    {
        for (int j = N; j >= y - d1 + d2; --j)
        {
            if (edge[i][j])
            {
                break;
            }
            P[4] += A[i][j];
        }
    }
    P[5] = total - P[1] - P[2] - P[3] - P[4];

    for (int i = 1; i <= 5; ++i)
    {
        cout << P[i] << " ";
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            cin >> A[i][j];
            total += A[i][j];
        }
    }

    solve(4, 3, 1, 1);

    // for (int x = 1; x <= N; ++x)
    // {
    //     for (int y = 1; y <= N; ++y)
    //     {
    //         for (int d1 = 1; d1 <= N; ++d1)
    //         {
    //             for (int d2 = 1; d2 <= N; ++d2)
    //             {
    //                 if (x + d1 + d2 <= N && y - d1 >= 1 && y + d2 <= N)
    //                 {
    //                     ans = min(ans, solve(x, y, d1, d2));
    //                 }
    //             }
    //         }
    //     }
    // }
    // cout << ans << "\n";

    return 0;
}
