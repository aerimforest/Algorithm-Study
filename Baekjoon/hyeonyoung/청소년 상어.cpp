// 220927_BOJ_19236

#include <iostream>
#include <vector>

using namespace std;

struct fish
{
    int x, y;
    int d;
};
vector<fish> fishh(18);
vector<vector<int>> arr(4, vector<int>(4));
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
int ans = 0;

void solve(int sum, vector<fish> fishes, vector<vector<int>> board)
{
    ans = max(ans, sum);

    // 물고기 이동
    for (int i = 1; i <= 16; ++i)
    {
        if (fishes[i].d == -1)
        {
            continue;
        }

        int x = fishes[i].x, y = fishes[i].y, d = fishes[i].d;
        for (int k = 0; k < 8; ++k)
        {
            int dd = (d + k) & 7;
            int xx = x + dx[dd], yy = y + dy[dd];

            if (xx < 0 || xx >= 4 || yy < 0 || yy >= 4 || board[xx][yy] == 17)
            {
                continue;
            }

            int j = board[xx][yy];
            fishes[j] = {x, y, fishes[j].d};
            fishes[i] = {xx, yy, dd};
            board[x][y] = j;
            board[xx][yy] = i;

            break;
        }
    }

    // 상어 이동
    int x = fishes[17].x, y = fishes[17].y, d = fishes[17].d;
    int xx = x + dx[d], yy = y + dy[d];
    while (xx >= 0 && xx < 4 && yy >= 0 && yy < 4)
    {
        if (board[xx][yy] >= 1 && board[xx][yy] <= 16)
        {
            int eat = board[xx][yy], dd = fishes[eat].d;
            board[xx][yy] = 17;
            board[x][y] = 0;
            fishes[17] = {xx, yy, dd};
            fishes[eat] = {x, y, -1};

            solve(sum + eat, fishes, board);

            board[x][y] = 17;
            board[xx][yy] = eat;
            fishes[eat] = {xx, yy, dd};
            fishes[17] = {x, y, d};
        }

        xx += dx[d];
        yy += dy[d];
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 4; ++i)
    {
        for (int j = 0; j < 4; ++j)
        {
            int n, d;
            cin >> n >> d;
            fishh[n] = {i, j, d - 1};
            arr[i][j] = n;
        }
    }

    int eat = arr[0][0];
    arr[0][0] = 17;
    fishh[17] = {0, 0, fishh[eat].d};
    fishh[eat] = {-1, -1, -1};

    solve(eat, fishh, arr);

    cout << ans;

    return 0;
}
