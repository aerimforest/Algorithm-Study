// 221225_BOJ_1194

#include <iostream>
#include <queue>

using namespace std;

int N, M, answer = -1;
char maze[51][51];
int visit[51][51][1 << 6];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

struct state
{
    int x, y, key;
};
queue<state> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> maze[i];
    }

    int x = -1, y;
    for (int i = 0; i < N && x == -1; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (maze[i][j] == '0')
            {
                maze[i][j] = '.';
                x = i;
                y = j;
                break;
            }
        }
    }

    visit[x][y][0] = 1;
    q.push({x, y, 0});
    while (!q.empty() && answer == -1)
    {
        int x = q.front().x, y = q.front().y, key = q.front().key;
        q.pop();

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }

            if (maze[xx][yy] == '.' && visit[xx][yy][key] == 0)
            {
                visit[xx][yy][key] = visit[x][y][key] + 1;
                q.push({xx, yy, key});
            }
            else if (maze[xx][yy] >= 'a' && maze[xx][yy] <= 'f' && visit[xx][yy][key | (1 << (maze[xx][yy] - 'a'))] == 0)
            {
                visit[xx][yy][key] = visit[x][y][key] + 1;
                visit[xx][yy][key | (1 << (maze[xx][yy] - 'a'))] = visit[x][y][key] + 1;
                q.push({xx, yy, key | (1 << (maze[xx][yy] - 'a'))});
            }
            else if (maze[xx][yy] >= 'A' && maze[xx][yy] <= 'F' && (key & (1 << (maze[xx][yy] - 'A'))) > 0 && visit[xx][yy][key] == 0)
            {
                visit[xx][yy][key] = visit[x][y][key] + 1;
                q.push({xx, yy, key});
            }
            else if (maze[xx][yy] == '1')
            {
                answer = visit[x][y][key];
                break;
            }
        }
    }
    cout << answer;

    return 0;
}
