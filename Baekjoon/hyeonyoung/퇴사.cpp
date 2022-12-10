// 221210_BOJ_14501

#include <iostream>

using namespace std;

int N;
pair<int, int> work[16];
int dp[16];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> work[i].first >> work[i].second;
    }

    for (int i = N - 1; i >= 0; --i)
    {
        if (i + work[i].first <= N)
        {
            dp[i] = max(dp[i + 1], dp[i + work[i].first] + work[i].second);
        }
        else
        {
            dp[i] = dp[i + 1];
        }
    }

    cout << dp[0];

    return 0;
}
