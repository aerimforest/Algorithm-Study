// 221202_BOJ_1167

#include <iostream>
#include <vector>

using namespace std;

int V, answer = 0;
vector<pair<int, int>> adj[100001]; // 정점, 거리

int solve(int cur, int par)
{
    int A = 0, B = 0;
    for (pair<int, int> next : adj[cur])
    {
        if (next.first == par)
        {
            continue;
        }

        int ret = solve(next.first, cur);
        if (A < ret + next.second)
        {
            B = A;
            A = ret + next.second;
        }
        else if (B < ret + next.second)
        {
            B = ret + next.second;
        }
    }
    answer = max(answer, A + B);

    return A;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> V;
    for (int i = 0; i < V; ++i)
    {
        int N, a, b;
        cin >> N;
        while (1)
        {
            cin >> a;
            if (a == -1)
            {
                break;
            }
            cin >> b;

            adj[N].push_back({a, b});
        }
    }

    solve(1, 0);
    cout << answer;

    return 0;
}
