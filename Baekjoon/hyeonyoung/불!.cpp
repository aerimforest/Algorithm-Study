// 220914_BOJ_4179

#include <iostream>
#include <queue>

using namespace std;

int R, C;
char maze[1001][1001];
int visit[1001][1001];
queue<pair<int, int>> jihun[2], fire[2];

int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C;
    for (int r = 0; r < R; ++r)
    {
        cin >> maze[r];
        for (int c = 0; c < C; ++c)
        {
            if (maze[r][c] == 'J')
            {
                maze[r][c] = '.';
                visit[r][c] = 1;
                jihun[0].push({r, c});
            }
            else if (maze[r][c] == 'F')
            {
                fire[0].push({r, c});
            }
        }
    }

    bool flag = false;
    int answer = -1;
    while (answer < 0 && !jihun[flag].empty())
    {
        // 지훈 이동
        jihun[!flag] = {};
        while (!jihun[flag].empty())
        {
            int x = jihun[flag].front().first, y = jihun[flag].front().second;
            jihun[flag].pop();

            if (maze[x][y] == 'F')
            {
                continue;
            }
            if (x == 0 || x == R - 1 || y == 0 || y == C - 1)
            {
                answer = visit[x][y];
                break;
            }

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= R || yy < 0 || yy >= C)
                {
                    continue;
                }
                if (maze[xx][yy] == '.' && visit[xx][yy] == 0)
                {
                    visit[xx][yy] = visit[x][y] + 1;
                    jihun[!flag].push({xx, yy});
                }
            }
        }

        // 불 이동
        fire[!flag] = {};
        while (answer < 0 && !fire[flag].empty())
        {
            int x = fire[flag].front().first, y = fire[flag].front().second;
            fire[flag].pop();

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= R || yy < 0 || yy >= C)
                {
                    continue;
                }
                if (maze[xx][yy] == '.')
                {
                    maze[xx][yy] = 'F';
                    fire[!flag].push({xx, yy});
                }
            }
        }

        flag = !flag;
        // for (int r = 0; r < R; ++r)
        // {
        //     for (int c = 0; c < C; ++c)
        //     {
        //         cout << visit[r][c] << " ";
        //     }
        //     cout << "\n";
        // }
        // for (int r = 0; r < R; ++r)
        // {
        //     cout << maze[r] << "\n";
        // }
        // cout << "\n";
    }

    if (answer < 0)
    {
        cout << "IMPOSSIBLE";
    }
    else
    {
        cout << answer;
    }

    return 0;
}
