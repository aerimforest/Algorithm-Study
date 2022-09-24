// 220925_BOJ_2805

#include <iostream>

using namespace std;

int N, M, tree[1000001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int l = 0, r = 0;

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> tree[i];
        r = max(r, tree[i]);
    }

    long long ans = 0;
    while (l <= r)
    {
        int m = ((l + r) >> 1);

        long long sum = 0;
        for (int i = 0; i < N; ++i)
        {
            sum += max(0, tree[i] - m);
        }

        if (sum >= M)
        {
            ans = max(ans, (long long)m);
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
