// 230112_BOJ_11779

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, A, B, D[1001][2];
vector<pair<int, int>> bus[1001];
struct state
{
    int x, cost;

    bool operator<(const state &X) const
    {
        return this->cost > X.cost;
    }
};
priority_queue<state> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i <= N; ++i)
    {
        D[i][0] = 0x7fffffff;
        D[i][1] = 0;
    }
    for (int i = 0; i < M; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;
        bus[a].push_back({b, c});
    }
    cin >> A >> B;

    D[A][0] = 0;
    pq.push({A, 0});
    while (!pq.empty())
    {
        int cur = pq.top().x, cost = pq.top().cost;
        pq.pop();

        if (D[cur][0] != cost)
        {
            continue;
        }
        if (cur == B)
        {
            cout << cost << "\n";
            vector<int> city;
            int x = B;
            while (x != 0)
            {
                city.push_back(x);
                x = D[x][1];
            }
            cout << city.size() << "\n";
            for (int i = city.size() - 1; i >= 0; --i)
            {
                cout << city[i] << " ";
            }
            break;
        }

        for (pair<int, int> next : bus[cur])
        {
            if (D[next.first][0] > cost + next.second)
            {
                D[next.first][0] = cost + next.second;
                D[next.first][1] = cur;
                pq.push({next.first, D[next.first][0]});
            }
        }
    }

    return 0;
}
