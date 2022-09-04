// 220904_BOJ_10026

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N;
char painting[101][101];
int visit[101][101];
queue<pair<int, int>> Q;

int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> painting[i];
    }

    // 정상
    int normal = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (visit[i][j])
            {
                continue;
            }

            visit[i][j] = ++normal;
            Q.push({i, j});

            while (!Q.empty())
            {
                int x = Q.front().first, y = Q.front().second;
                Q.pop();

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];

                    if (xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy] != 0 || painting[xx][yy] != painting[x][y])
                    {
                        continue;
                    }

                    visit[xx][yy] = visit[x][y];
                    Q.push({xx, yy});
                }
            }
        }
    }

    // 적록색약
    int color = 0;
    memset(visit, 0, sizeof(visit));
    Q = {};
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (visit[i][j])
            {
                continue;
            }

            visit[i][j] = ++color;
            Q.push({i, j});

            while (!Q.empty())
            {
                int x = Q.front().first, y = Q.front().second;
                Q.pop();

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];

                    if (xx < 0 || xx >= N || yy < 0 || yy >= N || visit[xx][yy] != 0)
                    {
                        continue;
                    }

                    if ((painting[x][y] == 'B' && painting[xx][yy] == 'B') || (painting[x][y] != 'B' && painting[xx][yy] != 'B'))
                    {
                        visit[xx][yy] = visit[x][y];
                        Q.push({xx, yy});
                    }
                }
            }
        }
    }

    cout << normal << " " << color;

    return 0;
}
