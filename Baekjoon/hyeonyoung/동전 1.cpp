// 220830_BOJ_2293

#include <iostream>
#include <algorithm>

using namespace std;

int N, K, coins[100];
int dp[10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> coins[i];
    }
    sort(coins, coins + N);

    dp[0] = 1;
    for (int i = 0; i < N; ++i)
    {
        int c = coins[i];
        for (int k = 1; k <= K; ++k)
        {
            if (k - c >= 0)
            {
                dp[k] += dp[k - c];
            }
        }
    }

    cout << dp[K];

    return 0;
}
