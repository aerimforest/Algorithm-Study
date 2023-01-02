// 230102_BOJ_2616

#include <iostream>

using namespace std;

int N, M, train[50001];
int dp[4][50001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> train[i];
        train[i] += train[i - 1];
    }
    cin >> M;

    for (int i = 1; i <= 3; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            if (j >= M)
            {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - M] + train[j] - train[j - M]);
            }
            else
            {
                dp[i][j] = dp[i][j - 1];
            }
        }
    }
    cout << dp[3][N];

    return 0;
}
