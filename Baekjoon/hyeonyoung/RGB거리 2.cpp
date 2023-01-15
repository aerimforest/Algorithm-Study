// 230115_BOJ_17404

#include <iostream>

using namespace std;

int N, cost[1001][3];
int dp[1001][3][3]; // N번째 시작색 현재색

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            cin >> cost[i][j];
        }
    }

    for (int i = 0; i < 3; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            if (i == j)
            {
                dp[0][i][j] = cost[0][i];
            }
            else
            {
                dp[0][i][j] = 987654321;
            }
        }
    }

    for (int i = 1; i < N; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 3; ++k)
            {
                dp[i][j][k] = min(dp[i - 1][j][(k + 1) % 3], dp[i - 1][j][(k + 2) % 3]) + cost[i][k];
            }
        }
    }

    int answer = 987654321;
    for (int i = 0; i < 3; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            if (i == j)
            {
                continue;
            }
            answer = min(answer, dp[N - 1][i][j]);
        }
    }
    cout << answer;

    return 0;
}
