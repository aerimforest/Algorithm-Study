// 220908_BOJ_9205

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int T, N;
pair<int, int> coord[102];
int visit[102];

int distance(pair<int, int> x, pair<int, int> y)
{
    int ret = 0;
    if (x.first >= y.first)
    {
        ret += x.first - y.first;
    }
    else
    {
        ret += y.first - x.first;
    }
    if (x.second >= y.second)
    {
        ret += x.second - y.second;
    }
    else
    {
        ret += y.second - x.second;
    }
    return ret;
}
bool solve()
{
    memset(visit, 0, sizeof(visit));
    queue<int> Q;

    visit[0] = 1;
    Q.push(0);

    while (!Q.empty())
    {
        int now = Q.front();
        Q.pop();

        if (now == N + 1)
        {
            return true;
        }

        for (int next = 1; next <= N + 1; ++next)
        {
            if (visit[next] == 0 && distance(coord[now], coord[next]) <= 1000)
            {
                visit[next] = 1;
                Q.push(next);
            }
        }
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> N;
        for (int i = 0; i <= N + 1; ++i)
        {
            int x, y;
            cin >> x >> y;
            coord[i] = {x, y};
        }

        if (solve())
        {
            cout << "happy\n";
        }
        else
        {
            cout << "sad\n";
        }
    }

    return 0;
}
