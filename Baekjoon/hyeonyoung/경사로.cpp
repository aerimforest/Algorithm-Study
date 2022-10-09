// 221008_BOJ_14890

#include <iostream>

using namespace std;

int N, L, board[101][101];
int ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> board[i][j];
        }
    }

    // 가로
    for (int i = 0; i < N; ++i)
    {
        int up = 1, down = 0;
        bool go = true;
        for (int j = 1; j < N; ++j)
        {
            if (board[i][j - 1] == board[i][j])
            {
                up++;
                down--;
            }
            else if (board[i][j - 1] + 1 == board[i][j])
            {
                if (up >= L && down <= 0)
                {
                    up = 1;
                    down = 0;
                }
                else
                {
                    go = false;
                    break;
                }
            }
            else if (board[i][j - 1] == board[i][j] + 1)
            {
                if (down <= 0)
                {
                    up = -(L - 1);
                    down = L - 1;
                }
                else
                {
                    break;
                }
            }
            else
            {
                go = false;
                break;
            }
        }
        if (down > 0)
        {
            go = false;
        }
        if (go)
        {
            ans++;
        }
    }
    // 세로
    for (int j = 0; j < N; ++j)
    {
        int up = 1, down = 0;
        bool go = true;
        for (int i = 1; i < N; ++i)
        {
            if (board[i - 1][j] == board[i][j])
            {
                up++;
                down--;
            }
            else if (board[i - 1][j] + 1 == board[i][j])
            {
                if (up >= L && down <= 0)
                {
                    up = 1;
                    down = 0;
                }
                else
                {
                    go = false;
                    break;
                }
            }
            else if (board[i - 1][j] == board[i][j] + 1)
            {
                if (down <= 0)
                {
                    up = -(L - 1);
                    down = L - 1;
                }
                else
                {
                    break;
                }
            }
            else
            {
                go = false;
                break;
            }
        }
        if (down > 0)
        {
            go = false;
        }
        if (go)
        {
            ans++;
        }
    }

    cout << ans;

    return 0;
}
