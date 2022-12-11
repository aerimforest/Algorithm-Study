// 221211_BOJ_11053

#include <iostream>

using namespace std;

int N, A[1001], dp[1001];
int answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    dp[0] = 1;
    for (int i = 1; i <= N; ++i)
    {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; --j)
        {
            if (A[j] < A[i])
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }

        answer = max(answer, dp[i]);
    }
    cout << answer;

    return 0;
}
