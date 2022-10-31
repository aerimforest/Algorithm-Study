// 221031_BOJ_17136

#include <iostream>
#include <vector>

using namespace std;

char board[11][11];
int ans = 10000;

void solve(int idx, vector<int> num)
{
    int chk = 0, x = idx / 10, y = idx % 10;
    for (int i = 0; i < 10; ++i)
    {
        for (int j = 0; j < 10; ++j)
        {
            if (board[i][j] == '1')
            {
                chk++;
            }
        }
    }
    if (chk == 0)
    {
        int sum = 0;
        for (int i = 0; i < 5; ++i)
        {
            sum += num[i];
        }
        ans = min(ans, sum);
        return;
    }
    if (idx > 100)
    {
        return;
    }

    if (board[x][y] == '1')
    {
        bool next = false;
        for (int k = 1; k <= 5; ++k)
        {
            if (x + k > 10 || y + k > 10)
            {
                continue;
            }

            int cnt = 0;
            for (int i = 0; i < k; ++i)
            {
                for (int j = 0; j < k; ++j)
                {
                    if (board[x + i][y + j] == '1')
                    {
                        cnt++;
                    }
                }
            }
            if (cnt == k * k && num[k - 1] < 5)
            {
                for (int i = 0; i < k; ++i)
                {
                    for (int j = 0; j < k; ++j)
                    {
                        board[x + i][y + j] = '0';
                    }
                }
                num[k - 1]++;
                next = true;
                solve(idx + 1, num);
                num[k - 1]--;
                if (cnt == k * k)
                {
                    for (int i = 0; i < k; ++i)
                    {
                        for (int j = 0; j < k; ++j)
                        {
                            board[x + i][y + j] = '1';
                        }
                    }
                }
            }
        }
        if (next == false)
        {
            return;
        }
    }
    else
    {
        solve(idx + 1, num);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 10; ++i)
    {
        for (int j = 0; j < 10; ++j)
        {
            cin >> board[i][j];
        }
    }

    solve(0, vector<int>(5, 0));

    if (ans == 10000)
    {
        ans = -1;
    }

    cout << ans;

    return 0;
}
