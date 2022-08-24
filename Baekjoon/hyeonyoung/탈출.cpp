// 220824_BOJ_3055

#include <iostream>
#include <queue>

using namespace std;

int R, C;
char forest[51][51];
queue<pair<int, int>> water, pine;
int visit[51][51], flood[51][51];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C;
    for (int i = 0; i < R; ++i)
    {
        cin >> forest[i];
        for (int j = 0; j < C; ++j)
        {
            if (forest[i][j] == 'S')
            {
                forest[i][j] = '.';
                pine.push({i, j});
                visit[i][j] = 1;
            }
            else if (forest[i][j] == '*')
            {
                water.push({i, j});
                flood[i][j] = 1;
            }
        }
    }

    while (1)
    {
        // 물 증가
        if (!water.empty())
        {
            int tmp = flood[water.front().first][water.front().second];
            while (!water.empty())
            {
                int x = water.front().first, y = water.front().second;
                if (tmp != flood[x][y])
                {
                    break;
                }
                water.pop();

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= R || yy < 0 || yy >= C || flood[xx][yy] > 0 || forest[xx][yy] != '.')
                    {
                        continue;
                    }

                    flood[xx][yy] = flood[x][y] + 1;
                    forest[xx][yy] = '*';
                    water.push({xx, yy});
                }
            }
        }

        // 고슴도치 이동
        if (pine.empty())
        {
            break;
        }
        int tmp = visit[pine.front().first][pine.front().second];
        while (!pine.empty())
        {
            int x = pine.front().first, y = pine.front().second;
            if (tmp != visit[x][y])
            {
                break;
            }
            pine.pop();

            if (forest[x][y] == 'D')
            {
                cout << visit[x][y] - 1;
                return 0;
            }

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= R || yy < 0 || yy >= C || visit[xx][yy] > 0 || forest[xx][yy] == 'X' || forest[xx][yy] == '*')
                {
                    continue;
                }

                visit[xx][yy] = visit[x][y] + 1;
                pine.push({xx, yy});
            }
        }
    }

    cout << "KAKTUS";

    return 0;
}
