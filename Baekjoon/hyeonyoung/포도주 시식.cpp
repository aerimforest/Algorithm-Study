// 220916_BOJ_2156

#include <iostream>

using namespace std;

int N, wine[10001];
int dp[10001][2];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> wine[i];
    }

    dp[1][0] = wine[1];
    dp[2][0] = wine[2];
    dp[2][1] = wine[1] + wine[2];
    for (int i = 3; i <= N; ++i)
    {
        dp[i][0] = wine[i] + max(max(dp[i - 2][0], dp[i - 2][1]), max(dp[i - 3][0], dp[i - 3][1]));
        dp[i][1] = wine[i] + dp[i - 1][0];
    }

    // for (int i = 1; i <= N; ++i)
    // {
    //     cout << wine[i] << " ";
    // }
    // cout << "\n";
    // for (int i = 1; i <= N; ++i)
    // {
    //     cout << dp[i][0] << " ";
    // }
    // cout << "\n";
    // for (int i = 1; i <= N; ++i)
    // {
    //     cout << dp[i][1] << " ";
    // }
    // cout << "\n";

    cout << max(dp[N - 1][1], max(dp[N][0], dp[N][1]));

    return 0;
}
