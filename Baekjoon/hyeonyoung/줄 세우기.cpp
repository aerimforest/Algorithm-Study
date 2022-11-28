// 221018_BOJ_2252

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int N, M, E[32001];
vector<int> adj[32001];
stack<int> S;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        E[b]++;
    }

    for (int i = 1; i <= N; ++i)
    {
        if (E[i] == 0)
        {
            S.push(i);
        }
    }

    while (!S.empty())
    {
        int cur = S.top();
        S.pop();

        cout << cur << " ";

        for (int next : adj[cur])
        {
            if (--E[next] == 0)
            {
                S.push(next);
            }
        }
    }

    return 0;
}
