// 221203_BOJ_1938

#include <iostream>
#include <queue>

using namespace std;

int N, answer = 0;
char board[51][51];
int visit[51][51][2]; // 0: 가로, 1: 세로
struct log
{
    int x, y;
    bool hor; // 가로
};
log S, E;

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
                    S = {i, j + 1, 0};
                    board[i][j] = board[i][j + 1] = board[i][j + 1] = '0';
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
                    E = {i, j + 1, 0};
                    board[i][j] = board[i][j + 1] = board[i][j + 1] = '0';
                }
            }
        }
    }

    queue<log> q;
    visit[S.x][S.y][S.hor] = 1;
    q.push(S);
    while (!q.empty())
    {
        int x = q.front().x, y = q.front().y, hor = q.front().hor;
        q.pop();

        // 가로
        if (hor)
        {
        }
    }

    return 0;
}
