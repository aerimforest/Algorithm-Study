// 221025_BOJ_2302

#include <iostream>

using namespace std;

int N, M, dp[41][2];
bool VIP[41];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int x;
        cin >> x;
        VIP[x] = true;
    }

    dp[1][1] = 1;
    for (int i = 2; i <= N; ++i)
    {
        if (VIP[i])
        {
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        else if (VIP[i - 1])
        {
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        else
        {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
    }

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

    cout << dp[N][0] + dp[N][1];

    return 0;
}
