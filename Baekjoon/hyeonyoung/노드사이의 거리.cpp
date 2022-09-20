// 220920_BOJ_1240

#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int N, M, D[1001][1001];
bool visit[1001];
vector<pair<int, int>> G[1001]; // next, cost
const int INF = 987654321;

int bfs(int x, int y)
{
    if (D[x][y])
    {
        return D[x][y];
    }

    memset(visit, false, sizeof(visit));
    queue<int> Q;
    visit[x] = true;
    Q.push(x);
    while (!Q.empty())
    {
        int cur = Q.front();
        Q.pop();

        for (pair<int, int> next : G[cur])
        {
            if (visit[next.first])
            {
                continue;
            }

            D[x][next.first] = D[next.first][x] = D[x][cur] + next.second;
            visit[next.first] = true;
            Q.push({next.first});
        }
    }

    return D[x][y];
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i < N; ++i)
    {
        int x, y, c;
        cin >> x >> y >> c;

        G[x].push_back({y, c});
        G[y].push_back({x, c});
        D[x][y] = D[y][x] = c;
    }

    for (int m = 0; m < M; ++m)
    {
        int x, y;
        cin >> x >> y;

        cout << bfs(x, y) << "\n";
    }

    return 0;
}
