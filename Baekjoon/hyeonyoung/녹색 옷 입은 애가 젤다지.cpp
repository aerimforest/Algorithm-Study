// 221017_BOJ_4485

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, cave[126][126], visit[126][126];
struct state
{
    int x, y;
    int cost;

    bool operator<(const state &S) const
    {
        return this->cost > S.cost;
    }
};
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
const int INF = 0x7fffffff;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int T = 1;; T++)
    {
        cin >> N;
        if (N == 0)
        {
            break;
        }

        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                cin >> cave[i][j];
                visit[i][j] = INF;
            }
        }

        priority_queue<state> Q;
        visit[0][0] = cave[0][0];
        Q.push({0, 0, visit[0][0]});

        while (!Q.empty())
        {
            int x = Q.top().x, y = Q.top().y, cost = Q.top().cost;
            Q.pop();

            if (x == N - 1 && y == N - 1)
            {
                cout << "Problem " << T << ": " << visit[x][y] << "\n";
                break;
            }

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                {
                    continue;
                }

                if (visit[xx][yy] > visit[x][y] + cave[xx][yy])
                {
                    visit[xx][yy] = visit[x][y] + cave[xx][yy];
                    Q.push({xx, yy, visit[xx][yy]});
                }
            }
        }
    }

    return 0;
}
