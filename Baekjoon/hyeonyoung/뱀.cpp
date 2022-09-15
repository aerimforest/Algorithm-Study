// 220915_BOJ_3190

#include <iostream>
#include <deque>

using namespace std;

int N, K, L;
int board[101][101]; // 1: 사과. 2: 뱀
deque<pair<int, int>> snake;
pair<int, char> direction[101];

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int k = 0; k < K; ++k)
    {
        int a, b;
        cin >> a >> b;

        board[a][b] = 1;
    }
    board[1][1] = 2;
    snake.push_back({1, 1});

    cin >> L;
    for (int l = 0; l < L; ++l)
    {
        cin >> direction[l].first >> direction[l].second;
    }

    int ans = -1, t = 1, d = 0;
    for (int l = 0; ans < 0 && l < L; ++l)
    {
        int T = direction[l].first;
        for (; t <= T; ++t)
        {
            int x = snake.front().first, y = snake.front().second;
            int xx = x + dx[d], yy = y + dy[d];

            if (xx <= 0 || xx > N || yy <= 0 || yy > N || board[xx][yy] == 2)
            {
                ans = t;
                break;
            }

            if (board[xx][yy] == 1)
            {
                board[xx][yy] = 2;
                snake.push_front({xx, yy});
            }
            else
            {
                board[xx][yy] = 2;
                snake.push_front({xx, yy});
                board[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
        }

        if (direction[l].second == 'D')
        {
            d = ((d + 1) & 3);
        }
        else
        {
            d = ((d + 3) & 3);
        }
    }
    if (ans < 0)
    {
        for (;; ++t)
        {
            int x = snake.front().first, y = snake.front().second;
            int xx = x + dx[d], yy = y + dy[d];

            if (xx <= 0 || xx > N || yy <= 0 || yy > N || board[xx][yy] == 2)
            {
                ans = t;
                break;
            }

            if (board[xx][yy] == 1)
            {
                board[xx][yy] = 2;
                snake.push_front({xx, yy});
            }
            else
            {
                board[xx][yy] = 2;
                snake.push_front({xx, yy});
                board[snake.back().first][snake.back().second] = 0;
                snake.pop_back();
            }
        }
    }
    cout << ans << "\n";

    return 0;
}
