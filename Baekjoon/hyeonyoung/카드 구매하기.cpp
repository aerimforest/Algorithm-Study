// 220904_BOJ_11052

#include <iostream>

using namespace std;

int N, P[1001];
int dp[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> P[i];
    }

    dp[1] = P[1];
    for (int i = 2; i <= N; ++i)
    {
        dp[i] = P[i];
        for (int j = 1; j < i; ++j)
        {
            dp[i] = max(dp[i], dp[i - j] + dp[j]);
        }
    }
    cout << dp[N];

    return 0;
}
