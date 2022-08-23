// 220823_BOJ_21758

#include <iostream>

using namespace std;

int N, P[100001];
int ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> P[i];
        P[i] += P[i - 1];
    }

    // 벌통이 왼쪽 끝에 있을 때
    for (int b = N - 2; b > 0; --b)
    {
        ans = max(ans, P[N - 2] + P[b - 1] - (P[b] - P[b - 1]));
    }

    // 벌통이 중간에 있을 때
    for (int x = 1; x < N - 1; ++x)
    {
        ans = max(ans, P[x] - P[0] + P[N - 2] - P[x - 1]);
    }

    // 벌통이 오른쪽 끝에 있을 때
    for (int b = 1; b < N - 1; ++b)
    {
        ans = max(ans, P[N - 1] - P[0] + P[N - 1] - P[b] - (P[b] - P[b - 1]));
    }

    cout << ans;

    return 0;
}
