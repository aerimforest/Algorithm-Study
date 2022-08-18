// 220817 BOJ 15486

#include <iostream>

using namespace std;

int N, T[1500001], P[1500001];
int dp[1500001]; // i~N까지 일했을 때 최대 수익

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> T[i] >> P[i];
    }

    for (int i = N - 1; i >= 0; --i)
    {
        if (i + T[i] - 1 < N)
        {
            dp[i] = max(dp[i + 1], dp[i + T[i]] + P[i]);
        }
        else
        {
            dp[i] = dp[i + 1];
        }
    }

    cout << dp[0];

    return 0;
}
