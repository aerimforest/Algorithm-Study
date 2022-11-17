// 221117_BOJ_9663

#include <iostream>

using namespace std;

int N, answer = 0;
bool visit[16], board[16][16];

void solve(int r)
{
    if (r == N)
    {
        answer++;
        return;
    }

    for (int i = 0; i < N; ++i)
    {
        if (visit[i])
        {
            continue;
        }
        bool possible = true;
        int x = r - 1, y = i - 1;
        while (x >= 0 && y >= 0)
        {
            if (board[x][y])
            {
                possible = false;
                break;
            }
            x--;
            y--;
        }
        x = r - 1, y = i + 1;
        while (x >= 0 && y < N)
        {
            if (board[x][y])
            {
                possible = false;
                break;
            }
            x--;
            y++;
        }

        if (possible)
        {
            board[r][i] = true;
            visit[i] = true;
            solve(r + 1);
            board[r][i] = false;
            visit[i] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    solve(0);

    cout << answer;

    return 0;
}
