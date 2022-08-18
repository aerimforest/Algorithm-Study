// 220817 BOJ 2615

#include <iostream>

using namespace std;

const int N = 19;
int board[22][22];

// 가로, 세로, 오른쪽아래, 오른쪽위
int dx[] = {0, 1, 1, -1};
int dy[] = {1, 0, 1, 1};

void solve()
{
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            if (board[i][j] == 0)
                continue;

            for (int k = 0; k < 4; ++k)
            {
                if (i - dx[k] > 0 && i - dx[k] <= N && j - dy[k] > 0 && j - dy[k] <= N && board[i - dx[k]][j - dy[k]] == board[i][j])
                    continue;

                int cnt = 1;
                int x = i + dx[k], y = j + dy[k];
                while (x > 0 && x <= N && y > 0 && y <= N && board[i][j] == board[x][y])
                {
                    cnt++;
                    x += dx[k];
                    y += dy[k];
                }
                if (cnt == 5)
                {
                    cout << board[i][j] << "\n";
                    cout << i << " " << j << "\n";
                    return;
                }
            }
        }
    }
    cout << "0\n";
    return;
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
