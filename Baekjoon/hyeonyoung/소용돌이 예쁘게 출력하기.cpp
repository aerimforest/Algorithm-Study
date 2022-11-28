// 221125_BOJ_1022

#include <iostream>

using namespace std;

int r1, c1, r2, c2;
int board[51][6], big = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> r1 >> c1 >> r2 >> c2;
    for (int i = r1; i <= r2; ++i)
    {
        for (int j = c1; j <= c2; ++j)
        {
            int x = 0;
            if (i <= -j)
            {
                x = max(abs(i), abs(j)) * 2;
                x *= x;
                x += i - j + 1;
            }
            else if (i < j)
            {
                x = max(abs(i), abs(j)) * 2 - 1;
                x *= x;
                x += j - i;
            }
            else
            {
                x = max(abs(i), abs(j)) * 2 + 1;
                x *= x;
                x += j - i;
            }
            board[i - r1][j - c1] = x;
            big = max(big, x);
        }
    }

    int d = 0;
    while (big > 0)
    {
        big /= 10;
        d++;
    }

    for (int i = 0; i <= r2 - r1; ++i)
    {
        for (int j = 0; j <= c2 - c1; ++j)
        {
            cout.width(d);
            cout.fill(' ');
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
