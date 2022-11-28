// 221018_BOJ_1922

#include <iostream>
#include <queue>

using namespace std;

int N, M;
int group[1001], ans = 0;
const int INF = 0x7fffffff;
struct state
{
    int a, b, c;

    bool operator<(const state &X) const
    {
        return this->c > X.c;
    }
};
priority_queue<state> pq;

int findGroup(int x)
{
    if (group[x] == x)
    {
        return x;
    }

    return group[x] = findGroup(group[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        group[i] = i;
    }
    for (int i = 0; i < M; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;

        pq.push({a, b, c});
    }

    while (!pq.empty())
    {
        int a = pq.top().a, b = pq.top().b, c = pq.top().c;
        pq.pop();

        int A = findGroup(a), B = findGroup(b);
        if (A == B)
        {
            continue;
        }

        group[B] = A;
        ans += c;
    }

    cout << ans;

    return 0;
}
