// 230113_BOJ_16118

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
int fox[4001], wolf[4001][2];
struct state
{
    int x, d, v;

    bool operator<(const state &X) const
    {
        return this->d > X.d;
    }
};
vector<pair<int, int>> adj[4001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
        adj[b].push_back({a, c});
    }

    for (int i = 1; i <= N; ++i)
    {
        fox[i] = wolf[i][0] = wolf[i][1] = 0x7fffffff;
    }

    // fox 속도 1/2
    priority_queue<state> pq;
    fox[1] = 0;
    pq.push({1, 0, 0});
    while (!pq.empty())
    {
        int x = pq.top().x, d = pq.top().d;
        pq.pop();

        if (fox[x] != d)
        {
            continue;
        }

        for (pair<int, int> next : adj[x])
        {
            if (fox[next.first] > d + next.second * 2)
            {
                fox[next.first] = d + next.second * 2;
                pq.push({next.first, fox[next.first], 2});
            }
        }
    }

    // wolf 속도 1, 1/4
    pq = {};
    wolf[1][0] = 0;
    pq.push({1, 0, 0});
    while (!pq.empty())
    {
        int x = pq.top().x, d = pq.top().d, v = pq.top().v;
        pq.pop();

        if (wolf[x][v] != d)
        {
            continue;
        }

        for (pair<int, int> next : adj[x])
        {
            if (wolf[next.first][!v] > d + next.second * (v == 0 ? 1 : 4))
            {
                wolf[next.first][!v] = d + next.second * (v == 0 ? 1 : 4);
                pq.push({next.first, wolf[next.first][!v], !v});
            }
        }
    }

    int answer = 0;
    for (int i = 2; i <= N; ++i)
    {
        if (fox[i] < min(wolf[i][0], wolf[i][1]))
        {
            answer++;
        }
    }
    cout << answer;

    return 0;
}
