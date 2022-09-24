// 220924_BOJ_1182

#include <iostream>

using namespace std;

int N, S, A[21];
int ans = 0;

void solve(int idx, int sum)
{
    if (idx == N)
    {
        if (sum == S)
        {
            ans++;
        }
        return;
    }

    solve(idx + 1, sum + A[idx]);
    solve(idx + 1, sum);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> S;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    solve(0, 0);

    if (S == 0)
    {
        ans--;
    }
    cout << ans;

    return 0;
}
