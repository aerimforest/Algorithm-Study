// 221006_BOJ_2512

#include <iostream>

using namespace std;

int N, request[10001], M;
int ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    int l = 0, r = 0;
    for (int i = 0; i < N; ++i)
    {
        cin >> request[i];
        r = max(r, request[i]);
    }
    cin >> M;

    while (l <= r)
    {
        int m = (l + r) / 2;

        int sum = 0;
        for (int i = 0; i < N; ++i)
        {
            sum += min(request[i], m);
        }

        if (sum <= M)
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
