// 220821_BOJ_15685

#include <iostream>
#include <vector>

using namespace std;

int N;
bool grid[101][101];

int dx[] = {1, 0, -1, 0};
int dy[] = {0, -1, 0, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    // 드래곤 커브
    cin >> N;
    while (N-- > 0)
    {
        int x, y, d, g;

        cin >> x >> y >> d >> g;

        vector<int> dir;

        grid[x][y] = true;
        x += dx[d];
        y += dy[d];
        grid[x][y] = true;
        dir.push_back(d);

        for (int i = 0; i < g; ++i)
        {
            for (int j = (1 << i) - 1; j >= 0; --j)
            {
                d = (dir[j] + 1) & 3;
                x += dx[d];
                y += dy[d];
                grid[x][y] = true;
                dir.push_back(d);
            }
        }
    }

    //
    int ans = 0;
    for (int i = 0; i < 100; ++i)
    {
        for (int j = 0; j < 100; ++j)
        {
            if (grid[i][j] && grid[i + 1][j] && grid[i][j + 1] && grid[i + 1][j + 1])
            {
                ans++;
            }
        }
    }
    cout << ans;

    return 0;
}
