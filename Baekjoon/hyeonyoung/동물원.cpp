// 221117_BOJ_1309

#include <iostream>

using namespace std;

int N, dp[100001][3];
const int DIV = 9901;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for (int i = 2; i <= N; ++i)
    {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
    }
    cout << (dp[N][0] + dp[N][1] + dp[N][2]) % DIV;

    return 0;
}
