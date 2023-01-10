// 230110_BOJ_21317

#include <iostream>

using namespace std;

int N, S[21], B[21], K;
int dp[21][2];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 2; i <= N; ++i)
    {
        cin >> S[i] >> B[i + 1];
        dp[i][0] = dp[i][1] = 20 * 5000 + 10;
    }
    cin >> K;

    for (int i = 2; i <= N; ++i)
    {
        if (i - 2 > 0)
            dp[i][0] = min(dp[i - 1][0] + S[i], dp[i - 2][0] + B[i]);
        else
            dp[i][0] = dp[i - 1][0] + S[i];
        if (i - 3 > 0)
            dp[i][1] = min(min(dp[i - 1][1] + S[i], dp[i - 2][1] + B[i]), dp[i - 3][0] + K);
    }
    cout << min(dp[N][0], dp[N][1]);

    return 0;
}
