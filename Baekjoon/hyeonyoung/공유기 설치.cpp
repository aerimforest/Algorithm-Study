// 221006_BOJ_2110

#include <iostream>
#include <algorithm>

using namespace std;

int N, C, houses[200001];
int ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> C;
    for (int i = 0; i < N; ++i)
    {
        cin >> houses[i];
    }
    sort(houses, houses + N);

    int l = 0, r = houses[N - 1] - houses[0];
    while (l <= r)
    {
        int m = (l + r) / 2;

        int cnt = 1, cur = 0;
        for (int i = 1; i < N; ++i)
        {
            if (houses[i] - houses[cur] >= m)
            {
                cur = i;
                cnt++;
            }
        }
        if (cnt >= C)
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
