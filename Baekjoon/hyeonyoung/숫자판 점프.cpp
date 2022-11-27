// 221127_BOJ_2210

#include <iostream>

using namespace std;

int board[5][5], answer = 0;
bool visit[1000000];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

void solve(int idx, int x, int y, int n)
{
    if (idx == 6)
    {
        if (!visit[n])
        {
            visit[n] = true;
            answer++;
        }
        return;
    }

    for (int k = 0; k < 4; ++k)
    {
        int xx = x + dx[k], yy = y + dy[k];
        if (xx < 0 || xx >= 5 || yy < 0 || yy >= 5)
        {
            continue;
        }
        solve(idx + 1, xx, yy, n * 10 + board[xx][yy]);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 5; ++i)
    {
        for (int j = 0; j < 5; ++j)
        {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < 5; ++i)
    {
        for (int j = 0; j < 5; ++j)
        {
            solve(1, i, j, board[i][j]);
        }
    }
    cout << answer;

    return 0;
}
