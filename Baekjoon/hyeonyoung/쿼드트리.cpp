// 220928_BOJ_1992

#include <iostream>

using namespace std;

int N;
char board[65][65];

void solve(int x, int y, int n)
{
    if (n == 1)
    {
        cout << board[x][y];
        return;
    }
    char c = board[x][y];
    bool b = true;
    for (int i = x; b && i < x + n; ++i)
    {
        for (int j = y; b && j < y + n; ++j)
        {
            if (c != board[i][j])
            {
                b = false;
                cout << "(";
                solve(x, y, n / 2);
                solve(x, y + n / 2, n / 2);
                solve(x + n / 2, y, n / 2);
                solve(x + n / 2, y + n / 2, n / 2);
                cout << ")";
            }
        }
    }
    if (b)
    {
        cout << c;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }

    solve(0, 0, N);

    return 0;
}
