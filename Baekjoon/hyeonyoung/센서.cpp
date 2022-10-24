// 221024_BOJ_2212

#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N, K, S[10001];
int ans = 0;
priority_queue<int> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> S[i];
    }
    sort(S, S + N);

    for (int i = 1; i < N; ++i)
    {
        ans += S[i] - S[i - 1];
        pq.push(S[i] - S[i - 1]);
    }

    for (int k = 1; k < K && !pq.empty(); ++k)
    {
        ans -= pq.top();
        pq.pop();
    }
    cout << ans;

    return 0;
}
