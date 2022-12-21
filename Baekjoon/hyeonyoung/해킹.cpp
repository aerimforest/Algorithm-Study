// 221221_BOJ_10282

#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int T, N, D, C;
struct state
{
    int x; // computer
    int t; // time

    bool operator<(const state &X) const
    {
        return this->t > X.t;
    }
};
vector<state> dependency[10001];
int visit[10001];
priority_queue<state> pq;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> N >> D >> C;
        for (int i = 1; i <= N; ++i)
        {
            dependency[i] = {};
        }
        memset(visit, 0, sizeof(visit));
        pq = {};
        visit[C] = 1;
        pq.push({C, 1});

        for (int i = 0; i < D; ++i)
        {
            int a, b, s;
            cin >> a >> b >> s;

            dependency[b].push_back({a, s});
        }

        int cnt = 0, answer = 0;
        while (!pq.empty())
        {
            int x = pq.top().x, t = pq.top().t;
            pq.pop();

            if (visit[x] != t)
            {
                continue;
            }
            cnt++;
            answer = max(answer, t);

            for (state next : dependency[x])
            {
                if (visit[next.x] == 0 || visit[next.x] > visit[x] + next.t)
                {
                    visit[next.x] = visit[x] + next.t;
                    pq.push({next.x, visit[next.x]});
                }
            }
        }
        cout << cnt << " " << answer - 1 << "\n";
    }

    return 0;
}
