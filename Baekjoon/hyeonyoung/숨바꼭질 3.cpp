// 221130_BOJ_13549

#include <iostream>
#include <queue>

using namespace std;

int N, K;
const int MAXN = 200000;
int visit[MAXN + 1];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    priority_queue<pair<int, int>> pq; // 시간, 위치

    pq.push({-1, N});
    while (!pq.empty())
    {
        int cur = pq.top().second, t = -pq.top().first;
        pq.pop();

        if (cur == K)
        {
            cout << t - 1;
            break;
        }

        if (visit[cur] != 0)
        {
            continue;
        }
        visit[cur] = t;

        if (cur * 2 <= MAXN && visit[cur * 2] == 0)
        {
            pq.push({-t, cur * 2});
        }
        if (cur + 1 <= MAXN && visit[cur + 1] == 0)
        {
            pq.push({-(t + 1), cur + 1});
        }
        if (cur - 1 >= 0 && visit[cur - 1] == 0)
        {
            pq.push({-(t + 1), cur - 1});
        }
    }

    return 0;
}
