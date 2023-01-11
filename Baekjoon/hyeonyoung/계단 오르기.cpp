// 230111_BOJ_2579

#include <iostream>

using namespace std;

int N, score[301];
int dp[301][2];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> score[i];
    }

    dp[1][0] = score[1];
    for (int i = 2; i <= N; ++i)
    {
        dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        dp[i][1] = dp[i - 1][0] + score[i];
    }
    cout << max(dp[N][0], dp[N][1]);

    return 0;
}
