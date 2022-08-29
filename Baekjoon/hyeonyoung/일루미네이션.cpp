// 220826_BOJ_5547

#include <iostream>
#include <queue>

using namespace std;

int W, H, house[102][102];
int visit[102][102];

int dx[6] = {-1, -1, 0, 0, 1, 1};
int dy[2][6] = {{-1, 0, -1, 1, -1, 0}, {0, 1, -1, 1, 0, 1}};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> W >> H;
    for (int i = 1; i <= H; ++i)
    {
        for (int j = 1; j <= W; ++j)
        {
            cin >> house[i][j];
        }
    }

    queue<pair<int, int>> Q;
    visit[0][0] = 1;
    Q.push({0, 0});

    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        for (int k = 0; k < 6; ++k)
        {
            int xx = x + dx[k], yy = y + dy[x & 1][k];
            if (xx < 0 || xx > H + 1 || yy < 0 || yy > W + 1 || visit[xx][yy] || house[xx][yy])
            {
                continue;
            }

            visit[xx][yy] = 1;
            Q.push({xx, yy});
        }
    }

    int ans = 0;
    for (int i = 1; i <= H; ++i)
    {
        for (int j = 1; j <= W; ++j)
        {
            if (house[i][j] == 0)
            {
                continue;
            }

            int cnt = 0;
            for (int k = 0; k < 6; ++k)
            {
                int x = i + dx[k], y = j + dy[i & 1][k];
                if (visit[x][y] == 1)
                {
                    cnt++;
                }
            }
            ans += cnt;
        }
    }
    cout << ans;

    return 0;
}
