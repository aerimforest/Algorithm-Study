// 221025_BOJ_1261

#include <iostream>
#include <queue>

using namespace std;

int M, N, visit[101][101];
char maze[101][101];
struct state
{
    int x, y, w;

    bool operator<(const state &X) const
    {
        return this->w > X.w;
    }
};
priority_queue<state> pq;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> maze[i];
    }

    visit[0][0] = 1;
    pq.push({0, 0});
    while (!pq.empty())
    {
        int x = pq.top().x, y = pq.top().y, w = pq.top().w;
        pq.pop();

        if (x == N - 1 && y == M - 1)
        {
            break;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }

            if (maze[xx][yy] == '0' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y];
                pq.push({xx, yy, visit[xx][yy]});
            }
            else if (maze[xx][yy] == '1' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                pq.push({xx, yy, visit[xx][yy]});
            }
        }
    }

    cout << visit[N - 1][M - 1] - 1;

    return 0;
}
