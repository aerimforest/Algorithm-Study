// 221203_BOJ_1938

#include <iostream>
#include <queue>

using namespace std;

int N, answer = 0;
char board[51][51];
int visit[51][51][2]; // 0: 가로, 1: 세로
struct Log
{
    int x, y;
    bool hor; // 가로
};
Log S, E;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (board[i][j] == 'B')
            {
                if (i + 1 < N && board[i + 1][j] == 'B')
                {
                    S = {i + 1, j, 0};
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = '0';
                }
                else
                {
                    S = {i, j + 1, 1};
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = '0';
                }
            }
            if (board[i][j] == 'E')
            {
                if (i + 1 < N && board[i + 1][j] == 'E')
                {
                    E = {i + 1, j, 0};
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = '0';
                }
                else
                {
                    E = {i, j + 1, 1};
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = '0';
                }
            }
        }
    }

    queue<Log> q;
    visit[S.x][S.y][S.hor] = 1;
    q.push(S);
    while (!q.empty())
    {
        int x = q.front().x, y = q.front().y;
        bool hor = q.front().hor;
        q.pop();

        if (x == E.x && y == E.y && hor == E.hor)
        {
            answer = visit[x][y][hor] - 1;
            break;
        }

        pair<int, int> coord[3];
        // 가로
        if (hor)
        {
            coord[0] = {x, y - 1};
            coord[1] = {x, y};
            coord[2] = {x, y + 1};
        }
        // 세로
        else
        {
            coord[0] = {x - 1, y};
            coord[1] = {x, y};
            coord[2] = {x + 1, y};
        }

        // UDLR
        for (int k = 0; k < 4; ++k)
        {
            bool mov = true;
            for (int i = 0; i < 3; ++i)
            {
                int xx = coord[i].first + dx[k], yy = coord[i].second + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                {
                    mov = false;
                    break;
                }
                if (board[xx][yy] == '1')
                {
                    mov = false;
                    break;
                }
            }
            if (mov && visit[x + dx[k]][y + dy[k]][hor] == 0)
            {
                visit[x + dx[k]][y + dy[k]][hor] = visit[x][y][hor] + 1;
                q.push({x + dx[k], y + dy[k], hor});
            }
        }
        // T
        bool mov = true;
        for (int i = x - 1; i <= x + 1 && mov; ++i)
        {
            for (int j = y - 1; j <= y + 1; ++j)
            {
                if (i < 0 || i >= N || j < 0 || j >= N)
                {
                    mov = false;
                    break;
                }
                if (board[i][j] == '1')
                {
                    mov = false;
                    break;
                }
            }
        }
        if (mov && visit[x][y][!hor] == 0)
        {
            visit[x][y][!hor] = visit[x][y][hor] + 1;
            q.push({x, y, !hor});
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << visit[i][j][0] << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";
    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << visit[i][j][1] << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";

    cout << answer;

    return 0;
}
