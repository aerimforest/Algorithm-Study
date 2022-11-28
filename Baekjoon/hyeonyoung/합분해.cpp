// 221120_BOJ_2225

#include <iostream>

using namespace std;

int N, K;
int dp[201][201]; // 0~N 중 K개 합 = N
const int DIV = 1000000000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int j = 0; j <= K; ++j)
    {
        dp[0][j] = 1;
    }
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= K; ++j)
        {
            for (int k = 0; k <= i; ++k)
            {
                dp[i][j] = (dp[i][j] + dp[i - k][j - 1]) % DIV;
            }
            dp[i][j] %= DIV;
        }
    }
    cout << dp[N][K];

    return 0;
}
