// 230102_BOJ_1753

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int V, E, K, D[20001];
vector<pair<int, int>> adj[20001];

const int INF = 0x7fffffff;

struct state
{
    int x, w;

    bool operator<(const state &X) const
    {
        return this->w > X.w;
    }
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> V >> E >> K;
    for (int i = 0; i < E; ++i)
    {
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].push_back({v, w});
    }
    for (int i = 1; i <= V; ++i)
    {
        D[i] = INF;
    }

    D[K] = 0;
    priority_queue<state> pq;
    pq.push({K, 0});
    while (!pq.empty())
    {
        int cur = pq.top().x, dis = pq.top().w;
        pq.pop();

        if (D[cur] != dis)
        {
            continue;
        }

        for (pair<int, int> next : adj[cur])
        {
            if (D[next.first] > dis + next.second)
            {
                D[next.first] = dis + next.second;
                pq.push({next.first, D[next.first]});
            }
        }
    }

    for (int i = 1; i <= V; ++i)
    {
        if (D[i] == INF)
        {
            cout << "INF\n";
        }
        else
        {
            cout << D[i] << "\n";
        }
    }

    return 0;
}
