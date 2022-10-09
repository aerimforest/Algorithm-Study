// 221009_BOJ_16432

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N;
vector<int> rice[1001];
int visit[1001][10];
queue<pair<int, int>> Q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int M;
        cin >> M;
        for (int j = 0; j < M; ++j)
        {
            int x;
            cin >> x;
            rice[i].push_back(x);
        }
    }

    for (int x : rice[0])
    {
        visit[0][x] = 100;
        Q.push({0, x});
    }

    vector<int> answer;
    while (!Q.empty() && answer.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        if (x == N - 1)
        {
            while (x >= 0)
            {
                answer.push_back(y);
                y = visit[x--][y];
            }
            break;
        }

        for (int next : rice[x + 1])
        {
            if (next == y)
            {
                continue;
            }
            if (visit[x + 1][next] == 0)
            {
                visit[x + 1][next] = y;
                Q.push({x + 1, next});
            }
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 1; j < 10; ++j)
    //     {
    //         cout << visit[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    if (answer.empty())
    {
        answer.push_back(-1);
    }

    int len = answer.size();
    for (int i = len - 1; i >= 0; --i)
    {
        cout << answer[i] << "\n";
    }

    return 0;
}
