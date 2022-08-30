// 220830_BOJ_10844

#include <iostream>

using namespace std;

int N;
int dp[101][10];
const int DIV = 1000000000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i < 10; ++i)
    {
        dp[1][i] = 1;
    }

    for (int i = 2; i <= N; ++i)
    {
        dp[i][0] = dp[i - 1][1];
        for (int j = 1; j < 9; ++j)
        {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIV;
        }
        dp[i][9] = dp[i - 1][8];
    }

    int ans = 0;
    for (int i = 0; i < 10; ++i)
    {
        ans = (ans + dp[N][i]) % DIV;
    }
    cout << ans;

    return 0;
}
