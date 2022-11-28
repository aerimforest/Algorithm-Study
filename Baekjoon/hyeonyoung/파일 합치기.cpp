// 221111_BOJ_11066

#include <iostream>
#include <cstring>

using namespace std;

int T, K;
int sum[501], dp[501][501];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> K;
        for (int i = 1; i <= K; ++i)
        {
            for (int j = 1; j <= K; ++j)
            {
                dp[i][j] = 987654321;
            }
        }

        for (int i = 1; i <= K; ++i)
        {
            int x;
            cin >> x;
            sum[i] = sum[i - 1] + x;
            dp[i][i] = 0;
        }

        for (int k = 1; k < K; ++k)
        {
            for (int x = 1, y = x + k; x <= K && y <= K; ++x, ++y)
            {
                for (int i = x; i < y; ++i)
                {
                    if (dp[x][y] > sum[y] - sum[x - 1] + dp[x][i] + dp[i + 1][y])
                    {
                        dp[x][y] = sum[y] - sum[x - 1] + dp[x][i] + dp[i + 1][y];
                    }
                }
            }
        }

        // for (int i = 1; i <= K; ++i)
        // {
        //     for (int j = i; j <= K; ++j)
        //     {
        //         cout << i << " " << j << " " << dp[i][j] << "\n";
        //     }
        // }

        int x = 1, y = K;
        cout << dp[x][y] << "\n";
    }

    return 0;
}
