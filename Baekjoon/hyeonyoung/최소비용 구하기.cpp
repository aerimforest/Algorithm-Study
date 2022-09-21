// 220912_BOJ_1916

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, S, E, D[1001];
struct bus
{
    int city;
    int cost;

    bool operator<(const bus x) const
    {
        return this->cost > x.cost;
    }
};
vector<bus> buses[1001];
priority_queue<bus> pq;
const int INF = 0x7fffffff;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;
        buses[a].push_back({b, c});
    }
    cin >> S >> E;

    for (int i = 1; i <= N; ++i)
    {
        D[i] = INF;
    }
    D[S] = 0;
    pq.push({S, 0});
    while (!pq.empty())
    {
        int cur = pq.top().city, cost = pq.top().cost;
        pq.pop();

        if (D[cur] != cost)
        {
            continue;
        }

        if (cur == E)
        {
            cout << cost;
            break;
        }

        for (bus next : buses[cur])
        {
            if (D[next.city] > D[cur] + next.cost)
            {
                D[next.city] = D[cur] + next.cost;
                pq.push({next.city, D[next.city]});
            }
        }
    }

    return 0;
}
