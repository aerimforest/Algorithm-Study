// 220928_BOJ_9019

#include <iostream>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

int T, A, B;
pair<int, char> visit[10000];
queue<int> Q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> A >> B;

        memset(visit, -1, sizeof(visit));
        Q = {};
        visit[A] = {A, ' '};
        Q.push(A);
        while (!Q.empty())
        {
            int cur = Q.front();
            Q.pop();

            if (cur == B)
            {
                vector<char> ans;
                while (cur != A)
                {
                    ans.push_back(visit[cur].second);
                    cur = visit[cur].first;
                }

                for (auto it = ans.end(); it != ans.begin(); --it)
                {
                    cout << *(it - 1);
                }
                cout << "\n";
                break;
            }

            // D
            int next = (cur << 1) % 10000;
            if (visit[next].first == -1)
            {
                visit[next] = {cur, 'D'};
                Q.push(next);
            }
            // S
            next = (cur + 9999) % 10000;
            if (visit[next].first == -1)
            {
                visit[next] = {cur, 'S'};
                Q.push(next);
            }
            // L
            next = ((cur * 10) + (cur / 1000)) % 10000;
            if (visit[next].first == -1)
            {
                visit[next] = {cur, 'L'};
                Q.push(next);
            }
            // R
            next = 1000 * (cur % 10) + cur / 10;
            if (visit[next].first == -1)
            {
                visit[next] = {cur, 'R'};
                Q.push(next);
            }
        }
    }

    return 0;
}
