// 221124_BOJ_11057

#include <iostream>

using namespace std;

int N, dp[1001][10];
const int DIV = 10007;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 10; ++i)
    {
        dp[1][i] = 1;
    }

    cin >> N;
    for (int i = 2; i <= N; ++i)
    {
        dp[i][0] = dp[i - 1][0];
        for (int j = 1; j < 10; ++j)
        {
            dp[i][j] = (dp[i][j] + dp[i - 1][j] + dp[i][j - 1]) % DIV;
        }
    }

    int answer = 0;
    for (int j = 0; j < 10; ++j)
    {
        answer = (answer + dp[N][j]) % DIV;
    }
    cout << answer;

    return 0;
}
