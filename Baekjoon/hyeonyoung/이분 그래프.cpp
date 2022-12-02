// 221202_BOJ_1707

#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int K, V, E;
vector<int> adj[20001];
int visit[20001];
bool answer;

void solve(int x)
{
    queue<int> q;

    visit[x] = 1;
    q.push(x);
    while (!q.empty() && answer)
    {
        int cur = q.front();
        q.pop();

        for (int next : adj[cur])
        {
            if (visit[next] == 0)
            {
                visit[next] = (visit[cur] & 1) + 1;
                q.push(next);
            }
            else if (visit[next] == visit[cur])
            {
                answer = false;
                break;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K;
    while (K-- > 0)
    {
        cin >> V >> E;
        for (int i = 1; i <= V; ++i)
        {
            adj[i] = {};
        }
        for (int i = 0; i < E; ++i)
        {
            int a, b;
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        answer = true;
        memset(visit, 0, sizeof(visit));
        for (int i = 1; i <= V; ++i)
        {
            if (visit[i] == 0)
            {
                solve(i);
            }
        }
        if (answer)
        {
            cout << "YES\n";
        }
        else
        {
            cout << "NO\n";
        }
    }

    return 0;
}
