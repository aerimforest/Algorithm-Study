// 221221_BOJ_1535

#include <iostream>

using namespace std;

int N, loss[21], joy[21];
int dp[21][101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> loss[i];
    }
    for (int i = 1; i <= N; ++i)
    {
        cin >> joy[i];
    }

    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j < 100; ++j)
        {
            if (j - loss[i] >= 0)
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - loss[i]] + joy[i]);
            else
            {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    cout << dp[N][99];

    return 0;
}
