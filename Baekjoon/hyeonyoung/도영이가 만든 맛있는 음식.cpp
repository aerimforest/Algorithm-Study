// 221020_BOJ_2961

#include <iostream>

using namespace std;

int N, S[11], B[11];
long long ans = 0x7fffffffffffffff;

void solve(int idx, long long s, long long b)
{
    if (idx == N)
    {
        if (b > 0)
            ans = min(ans, abs(s - b));
        return;
    }

    if (s * S[idx] > 0)
        solve(idx + 1, s * S[idx], b + B[idx]);
    solve(idx + 1, s, b);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> S[i] >> B[i];
    }

    solve(0, 1, 0);

    cout << ans;

    return 0;
}
