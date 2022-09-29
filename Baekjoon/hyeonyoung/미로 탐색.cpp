// 220929_BOJ_2178

#include <iostream>
#include <queue>

using namespace std;

int N, M;
char maze[101][101];
int visit[101][101];
queue<pair<int, int>> Q;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> maze[i];
    }

    visit[0][0] = 1;
    Q.push({0, 0});
    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        if (x == N - 1 && y == M - 1)
        {
            cout << visit[x][y] << "\n";
            break;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];

            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }
            if (maze[xx][yy] == '1' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }
    }

    return 0;
}
