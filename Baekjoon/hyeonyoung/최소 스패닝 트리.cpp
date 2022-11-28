// 221021_BOJ_1197

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int V, E, ans = 0;
bool connect[10001];
struct state
{
    int a, b, c;

    bool operator<(const state &X) const
    {
        return this->c > X.c;
    }
};
vector<state> adj[10001];
priority_queue<state> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> V >> E;
    while (E-- > 0)
    {
        int a, b, c;
        cin >> a >> b >> c;

        adj[a].push_back({a, b, c});
        adj[b].push_back({a, b, c});
    }

    connect[1] = true;
    for (state s : adj[1])
    {
        pq.push(s);
    }

    while (!pq.empty())
    {
        state t = pq.top();
        pq.pop();

        if (!connect[t.a])
        {
            connect[t.a] = true;
            ans += t.c;
            for (state s : adj[t.a])
            {
                if (!connect[s.a] || !connect[s.b])
                {
                    pq.push(s);
                }
            }
        }
        else if (!connect[t.b])
        {
            connect[t.b] = true;
            ans += t.c;
            for (state s : adj[t.b])
            {
                if (!connect[s.a] || !connect[s.b])
                {
                    pq.push(s);
                }
            }
        }
    }

    cout << ans;

    return 0;
}
