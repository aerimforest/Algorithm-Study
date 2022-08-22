// 220822_BOJ_7569

#include <iostream>
#include <queue>

using namespace std;

int M, N, H, tomatoes[101][101][101]; // H M N

int dx[] = {-1, 1, 0, 0, 0, 0};
int dy[] = {0, 0, -1, 1, 0, 0};
int dz[] = {0, 0, 0, 0, -1, 1};

struct Tomato
{
    int x, y, z;
};
queue<Tomato> Q;
int green = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N >> H;
    for (int i = 0; i < H; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            for (int k = 0; k < M; ++k)
            {
                cin >> tomatoes[i][j][k];
                if (tomatoes[i][j][k] == 1)
                {
                    Q.push({i, j, k});
                }
                else if (tomatoes[i][j][k] == 0)
                {
                    green++;
                }
            }
        }
    }

    int ans = 0;
    while (!Q.empty() && green > 0)
    {
        int x = Q.front().x, y = Q.front().y, z = Q.front().z;
        Q.pop();

        for (int k = 0; k < 6; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k], zz = z + dz[k];

            if (xx < 0 || xx >= H || yy < 0 || yy >= N || zz < 0 || zz >= M)
            {
                continue;
            }
            if (tomatoes[xx][yy][zz] == 0)
            {
                tomatoes[xx][yy][zz] = tomatoes[x][y][z] + 1;
                green--;
                Q.push({xx, yy, zz});
                ans = tomatoes[x][y][z];
            }
        }
    }

    if (green > 0)
    {
        ans = -1;
    }

    cout << ans;

    return 0;
}
