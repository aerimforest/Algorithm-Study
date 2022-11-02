// 221102_BOJ_1890

#include <iostream>

using namespace std;

int N, board[101][101];
long long dp[101][101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> board[i][j];
        }
    }

    dp[0][0] = 1;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (dp[i][j] == 0 || board[i][j] == 0)
            {
                continue;
            }

            if (i + board[i][j] < N)
            {
                dp[i + board[i][j]][j] += dp[i][j];
            }
            if (j + board[i][j] < N)
            {
                dp[i][j + board[i][j]] += dp[i][j];
            }
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << dp[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    cout << dp[N - 1][N - 1];

    return 0;
}
