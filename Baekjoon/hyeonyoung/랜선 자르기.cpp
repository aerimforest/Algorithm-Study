// 221010_BOJ_1654

#include <iostream>

using namespace std;

int K, N, A[10001];
long long ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K >> N;
    for (int i = 0; i < K; ++i)
    {
        cin >> A[i];
    }

    long long l = 1, r = 0x7fffffff;
    while (l <= r)
    {
        long long m = (l + r) >> 1;

        int cnt = 0;
        for (int i = 0; i < K; ++i)
        {
            cnt += A[i] / m;
        }

        if (cnt >= N)
        {
            ans = max(ans, m);
            l = m + 1;
        }
        else
        {
            r = m - 1;
        }
    }
    cout << ans;

    return 0;
}
