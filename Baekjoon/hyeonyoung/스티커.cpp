// 220912_BOJ_9465

#include <iostream>
#include <cstring>

using namespace std;

int T, N, sticker[2][100001];
int dp[2][100001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        memset(dp, 0, sizeof(dp));

        cin >> N;
        for (int i = 0; i < 2; ++i)
        {
            for (int j = 1; j <= N; ++j)
            {
                cin >> sticker[i][j];
            }
        }

        dp[0][1] = sticker[0][1];
        dp[1][1] = sticker[1][1];
        for (int j = 2; j <= N; ++j)
        {
            dp[0][j] = max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
            dp[1][j] = max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
        }

        cout << max(dp[0][N], dp[1][N]) << "\n";
    }

    return 0;
}
