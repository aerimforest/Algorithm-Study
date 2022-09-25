// 220925_BOJ_1202

#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, K, C[300001];
pair<int, int> jew[300001]; // 무게, 가격
priority_queue<int> pq;     // 가격

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        int m, v;
        cin >> m >> v;
        jew[i] = {m, v};
    }
    sort(jew, jew + N);

    for (int i = 0; i < K; ++i)
    {
        cin >> C[i];
    }
    sort(C, C + K);

    long long ans = 0;
    int idx = 0;
    for (int i = 0; i < K; ++i)
    {
        while (idx < N && jew[idx].first <= C[i])
        {
            pq.push(jew[idx++].second);
        }
        if (!pq.empty())
        {
            ans += pq.top();
            pq.pop();
        }
    }
    cout << ans;

    return 0;
}
