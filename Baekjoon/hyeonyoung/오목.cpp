// 220817 BOJ 2615

#include <iostream>

using namespace std;

const int N = 19;
int board[22][22];

void solve()
{
    int cnt;

    // 가로
    for (int i = 1; i <= N; ++i)
    {
        int cnt = 0;
        for (int j = 1; j <= N + 1; ++j)
        {
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i][j - 1] << "\n";
                    cout << i << " " << j - 5 << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i][j - 1] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i][j - 1] << "\n";
                    cout << i << " " << j - 5 << "\n";

                    return;
                }
                cnt = 1;
            }
        }
    }
    // 세로
    for (int j = 1; j <= N; ++j)
    {
        int cnt = 0;
        for (int i = 1; i <= N + 1; ++i)
        {
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j] << "\n";
                    cout << i - 5 << " " << j << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i - 1][j] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j] << "\n";
                    cout << i - 5 << " " << j << "\n";

                    return;
                }
                cnt = 1;
            }
        }
    }
    // 오른쪽아래 대각선
    for (int k = N - 5; k >= 0; --k)
    {
        int cnt = 0;
        for (int j = k + 1; j <= N + 1; ++j)
        {
            int i = j - k;
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j - 1] << "\n";
                    cout << i - 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i - 1][j - 1] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j - 1] << "\n";
                    cout << i - 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 1;
            }
        }
        cnt = 0;
        for (int i = k + 1; i <= N + 1; ++i)
        {
            int j = i - k;
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j - 1] << "\n";
                    cout << i - 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i - 1][j - 1] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i - 1][j - 1] << "\n";
                    cout << i - 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 1;
            }
        }
    }
    // 오른쪽위 대각선
    for (int k = 6; k <= N; ++k)
    {
        int cnt = 0;
        for (int i = k - 1; i >= 0; --i)
        {
            int j = k - i;
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i + 1][j - 1] << "\n";
                    cout << i + 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i + 1][j - 1] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i + 1][j - 1] << "\n";
                    cout << i + 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 1;
            }
        }
    }
    for (int k = N + 1; k <= 2 * N - 4; ++k)
    {
        int cnt = 0;
        for (int j = 1; j <= N + 1; ++j)
        {
            int i = k - j;
            if (board[i][j] == 0)
            {
                if (cnt == 5)
                {
                    cout << board[i + 1][j - 1] << "\n";
                    cout << i + 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 0;
            }
            else if (board[i + 1][j - 1] == board[i][j])
            {
                cnt++;
            }
            else
            {
                if (cnt == 5)
                {
                    cout << board[i + 1][j - 1] << "\n";
                    cout << i + 5 << " " << j - 5 << "\n";

                    return;
                }
                cnt = 1;
            }
        }
    }

    cout << "0\n";
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            cin >> board[i][j];
        }
    }

    solve();

    return 0;
}
