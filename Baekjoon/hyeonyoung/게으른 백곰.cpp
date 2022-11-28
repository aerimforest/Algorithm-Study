// 221102_BOJ_10025

#include <iostream>
#include <algorithm>

using namespace std;

int N, K;
pair<int, int> bucket[100001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> bucket[i].second >> bucket[i].first;
    }
    sort(bucket, bucket + N);

    int x = 0, y = 0;
    long long sum = bucket[0].second, ans = 0;
    while (x < N)
    {
        ans = max(ans, sum);

        if (y + 1 < N && bucket[y + 1].first - bucket[x].first <= 2 * K)
        {
            sum += bucket[++y].second;
        }
        else if (x == y)
        {
            x++;
            y++;
            sum = bucket[x].second;
        }
        else
        {
            sum -= bucket[x++].second;
        }
    }
    cout << ans;

    return 0;
}
