// 221016_BOJ_1595

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> adj[10001];
int visit[10001];
int ans = 0;

int dfs(int cur)
{
    if (visit[cur])
    {
        return 0;
    }
    visit[cur] = 1;

    priority_queue<int> tmp;
    for (pair<int, int> next : adj[cur])
    {
        if (visit[next.first])
        {
            continue;
        }

        tmp.push(dfs(next.first) + next.second);
    }

    int one = 0, two = 0;
    if (!tmp.empty())
    {
        one = tmp.top();
        tmp.pop();
    }
    if (!tmp.empty())
    {
        two = tmp.top();
        tmp.pop();
    }

    if (ans < one + two)
    {
        ans = one + two;
    }

    return one;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    while (1)
    {
        cin >> a >> b >> c;
        if (cin.eof())
        {
            break;
        }

        adj[a].push_back({b, c});
        adj[b].push_back({a, c});
    }

    dfs(a);
    cout << ans;

    return 0;
}
