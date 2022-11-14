// 221114_BOJ_17471

#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int N, P[11], psum = 0, answer = 0x7fffffff;
vector<int> adj[11];
bool choice[11];
int division[11];

void solve(int idx)
{
    if (idx > N)
    {
        memset(division, 0, sizeof(division));
        int cnt = 0, csum = 0;
        for (int i = 1; i <= N; ++i)
        {
            if (division[i] != 0)
            {
                continue;
            }

            int sum = 0;
            queue<int> q;
            q.push(i);
            division[i] = ++cnt;
            while (!q.empty())
            {
                int x = q.front();
                q.pop();
                sum += P[x];

                for (int y : adj[x])
                {
                    if (division[y] == 0 && choice[y] == choice[x])
                    {
                        q.push(y);
                        division[y] = division[x];
                    }
                }
            }
            if (csum == 0)
            {
                csum = sum;
            }
        }

        if (cnt == 2)
        {
            answer = min(answer, abs(psum - 2 * csum));
        }

        return;
    }

    choice[idx] = true;
    solve(idx + 1);
    choice[idx] = false;
    solve(idx + 1);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; ++i)
    {
        cin >> P[i];
        psum += P[i];
    }
    for (int i = 1; i <= N; ++i)
    {
        int x;
        cin >> x;
        for (int j = 0; j < x; ++j)
        {
            int y;
            cin >> y;
            adj[i].push_back(y);
        }
    }

    solve(1);
    if (answer == 0x7fffffff)
    {
        answer = -1;
    }
    cout << answer;

    return 0;
}
