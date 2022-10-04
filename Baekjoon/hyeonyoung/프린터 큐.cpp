// 221004_BOJ_1966

#include <iostream>
#include <queue>
#include <set>

using namespace std;

int T, N, M;
queue<pair<int, int>> Q;
set<int> priority[10];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        Q = {};
        for (int i = 0; i < 10; ++i)
        {
            priority[i] = {};
        }

        cin >> N >> M;
        for (int i = 0; i < N; ++i)
        {
            int p;
            cin >> p;

            Q.push({i, p});
            priority[p].insert(i);
        }

        int cnt = 0;
        while (!Q.empty())
        {
            int cur = Q.front().first, p = Q.front().second;
            Q.pop();

            bool flg = true;
            for (int i = p + 1; i < 10; ++i)
            {
                if (!priority[i].empty())
                {
                    flg = false;
                    break;
                }
            }

            if (flg)
            {
                cnt++;
                priority[p].erase(cur);
                if (cur == M)
                {
                    cout << cnt << "\n";
                    break;
                }
            }
            else
            {
                Q.push({cur, p});
            }
        }
    }

    return 0;
}
