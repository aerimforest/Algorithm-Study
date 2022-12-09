// 221209_BOJ_11559

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

char board[12][7];
int visit[12][7];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

bool solve()
{
    bool ret = false;
    memset(visit, 0, sizeof(visit));

    for (int i = 0; i < 12; ++i)
    {
        for (int j = 0; j < 6; ++j)
        {
            if (board[i][j] == '.' || visit[i][j])
            {
                continue;
            }

            int cnt = 0;

            queue<pair<int, int>> q, qq;
            visit[i][j] = 1;
            q.push({i, j});
            while (!q.empty())
            {
                cnt++;
                int x = q.front().first, y = q.front().second;
                q.pop();
                qq.push({x, y});

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= 12 || yy < 0 || yy >= 6)
                    {
                        continue;
                    }

                    if (board[xx][yy] == board[x][y] && visit[xx][yy] == 0)
                    {
                        visit[xx][yy] = 1;
                        q.push({xx, yy});
                    }
                }
            }
            if (cnt >= 4)
            {
                ret = true;
                while (!qq.empty())
                {
                    int x = qq.front().first, y = qq.front().second;
                    qq.pop();

                    visit[x][y] = 2;
                }
            }
        }
    }

    if (!ret)
    {
        return ret;
    }

    for (int i = 0; i < 12; ++i)
    {
        for (int j = 0; j < 6; ++j)
        {
            if (visit[i][j] == 2)
            {
                board[i][j] = '.';
            }
        }
    }

    for (int j = 0; j < 6; ++j)
    {
        queue<char> q;
        for (int i = 11; i >= 0; --i)
        {
            if (board[i][j] != '.')
            {
                q.push(board[i][j]);
            }
        }

        for (int i = 11; i >= 0; --i)
        {
            if (!q.empty())
            {
                board[i][j] = q.front();
                q.pop();
            }
            else
            {
                board[i][j] = '.';
            }
        }
    }

    // for (int i = 0; i < 12; ++i)
    // {
    //     for (int j = 0; j < 6; ++j)
    //     {
    //         cout << board[i][j];
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";

    return true;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 12; ++i)
    {
        cin >> board[i];
    }

    for (int i = 0;; ++i)
    {
        if (!solve())
        {
            cout << i;
            break;
        }
    }

    return 0;
}
