// 221112_BOJ_1932

#include <iostream>

using namespace std;

int N, tri[501][501];
int dp[501][501];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= i; ++j)
        {
            cin >> tri[i][j];
        }
    }

    dp[1][1] = tri[1][1];
    for (int i = 2; i <= N; ++i)
    {
        for (int j = 1; j <= i; ++j)
        {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
        }
    }

    int answer = 0;
    for (int j = 1; j <= N; ++j)
    {
        answer = max(answer, dp[N][j]);
    }
    cout << answer;

    return 0;
}
