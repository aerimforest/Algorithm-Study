// 220921_BOJ_1715

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, ans = 0;
priority_queue<int, vector<int>, greater<int>> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int card;
        cin >> card;

        pq.push(card);
    }

    while (pq.size() > 1)
    {
        int a = pq.top();
        pq.pop();
        int b = pq.top();
        pq.pop();

        ans += a + b;
        pq.push(a + b);
    }

    cout << ans;

    return 0;
}
