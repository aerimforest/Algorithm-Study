// 221215_BOJ_19535

#include <iostream>
#include <vector>

using namespace std;

int N;
long long D = 0, G = 0;
vector<int> adj[300001];

void dfs(int cur, int par)
{
    long long child = adj[cur].size();
    // G
    if (child >= 3)
    {
        G += child * (child - 1) * (child - 2) / 6;
    }

    // D
    for (int next : adj[cur])
    {
        if (next == par)
        {
            continue;
        }
        D += (child - 1) * (adj[next].size() - 1);
        dfs(next, cur);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i < N; ++i)
    {
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, 0);

    if (D > 3 * G)
    {
        cout << "D";
    }
    else if (D < 3 * G)
    {
        cout << "G";
    }
    else
    {
        cout << "DUDUDUNGA";
    }

    return 0;
}
