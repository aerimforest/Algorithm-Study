#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(int N, vector<vector<int>> road, int K)
{
    int towns[51][51];
    const int INF = 987654321;

    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            towns[i][j] = INF;
        }
        towns[i][i] = 0;
    }

    for (auto r : road)
    {
        int a = r[0], b = r[1], c = r[2];
        towns[a][b] = towns[b][a] = min(towns[a][b], c);
    }

    int D[51];
    D[1] = 0;
    for (int i = 2; i <= N; ++i)
    {
        D[i] = INF;
    }

    struct delivery
    {
        int town, distance;

        bool operator<(const delivery &x) const
        {
            return this->distance > x.distance;
        }
    };

    priority_queue<delivery> PQ;
    PQ.push({1, 0});
    while (!PQ.empty())
    {
        int now = PQ.top().town, distance = PQ.top().distance;
        PQ.pop();

        if (D[now] != distance)
        {
            continue;
        }

        for (int next = 2; next <= N; ++next)
        {
            if (D[next] > distance + towns[now][next])
            {
                D[next] = distance + towns[now][next];
                PQ.push({next, D[next]});
            }
        }
    }

    int ans = 0;
    for (int i = 1; i <= N; ++i)
    {
        if (D[i] <= K)
        {
            ans++;
        }
    }
    return ans;
}
