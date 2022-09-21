// 220911_BOJ_17837

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int N, K, board[13][13];
int dx[] = {0, 0, 0, -1, 1};
int dy[] = {0, 1, -1, 0, 0};
struct horse
{
    int r, c;
    int d;
} horses[11];
stack<int> game[13][13];

void white(int k, int x, int y, int d, int xx, int yy)
{
    vector<int> tmp;
    while (!game[x][y].empty())
    {
        int t = game[x][y].top();
        game[x][y].pop();
        tmp.push_back(t);
        if (t == k)
        {
            break;
        }
    }

    for (int i = tmp.size() - 1; i >= 0; --i)
    {
        horses[tmp[i]].r = xx;
        horses[tmp[i]].c = yy;
        game[xx][yy].push(tmp[i]);
    }
}
void red(int k, int x, int y, int d, int xx, int yy)
{
    vector<int> tmp;
    while (!game[x][y].empty())
    {
        int t = game[x][y].top();
        game[x][y].pop();
        tmp.push_back(t);
        if (t == k)
        {
            break;
        }
    }

    for (int i = 0; i < tmp.size(); ++i)
    {
        horses[tmp[i]].r = xx;
        horses[tmp[i]].c = yy;
        game[xx][yy].push(tmp[i]);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            cin >> board[i][j];
        }
    }
    for (int i = 1; i <= K; ++i)
    {
        int r, c, d;
        cin >> r >> c >> d;
        horses[i] = {r, c, d};
        game[r][c].push(i);
    }

    int ans = -1;
    for (int T = 1; T <= 1000 && ans == -1; ++T)
    {
        for (int k = 1; k <= K; ++k)
        {
            int x = horses[k].r, y = horses[k].c, d = horses[k].d;
            int xx = x + dx[d], yy = y + dy[d];

            // 2: blue
            if (xx <= 0 || xx > N || yy <= 0 || yy > N || board[xx][yy] == 2)
            {
                if (d & 1)
                {
                    horses[k].d = d = d + 1;
                }
                else
                {
                    horses[k].d = d = d - 1;
                }
                xx = x + dx[d], yy = y + dy[d];

                if (xx <= 0 || xx > N || yy <= 0 || yy > N || board[xx][yy] == 2)
                {
                    continue;
                }
                if (board[xx][yy] == 0)
                {
                    white(k, x, y, d, xx, yy);
                }
                else if (board[xx][yy] == 1)
                {
                    red(k, x, y, d, xx, yy);
                }
            }
            // 0: white
            else if (board[xx][yy] == 0)
            {
                white(k, x, y, d, xx, yy);
            }
            // 1: red
            else if (board[xx][yy] == 1)
            {
                red(k, x, y, d, xx, yy);
            }

            if (game[xx][yy].size() >= 4)
            {
                ans = T;
                break;
            }
        }
    }

    cout << ans;

    return 0;
}
