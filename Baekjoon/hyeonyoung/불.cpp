// 221228_BOJ_5427

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int T, W, H;
char building[1001][1001];
int visit[1001][1001];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

struct th
{
    int x, y;
    bool fire;
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        memset(visit, 0, sizeof(visit));

        cin >> W >> H;
        for (int i = 0; i < H; ++i)
        {
            cin >> building[i];
        }

        queue<th> q;
        for (int i = 0; i < H; ++i)
        {
            for (int j = 0; j < W; ++j)
            {
                if (building[i][j] == '@')
                {
                    building[i][j] = '.';
                    visit[i][j] = 1;
                    q.push({i, j, false});
                }
            }
        }
        for (int i = 0; i < H; ++i)
        {
            for (int j = 0; j < W; ++j)
            {
                if (building[i][j] == '*')
                {
                    q.push({i, j, true});
                }
            }
        }

        int answer = -1;
        while (!q.empty() && answer == -1)
        {
            int x = q.front().x, y = q.front().y;
            bool fire = q.front().fire;
            q.pop();

            if (!fire)
            {
                if (building[x][y] == '*')
                {
                    continue;
                }
                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= H || yy < 0 || yy >= W)
                    {
                        answer = visit[x][y];
                        break;
                    }
                    else if (building[xx][yy] == '.' && visit[xx][yy] == 0)
                    {
                        visit[xx][yy] = visit[x][y] + 1;
                        q.push({xx, yy, false});
                    }
                }
            }
            else
            {
                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= H || yy < 0 || yy >= W)
                    {
                        continue;
                    }
                    else if (building[xx][yy] == '.')
                    {
                        building[xx][yy] = '*';
                        q.push({xx, yy, true});
                    }
                }
            }
        }
        if (answer == -1)
        {
            cout << "IMPOSSIBLE\n";
        }
        else
        {
            cout << answer << "\n";
        }
    }

    return 0;
}
