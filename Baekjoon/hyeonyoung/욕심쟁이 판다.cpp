// 221026_BOJ_1937

#include <iostream>

using namespace std;

int N, F[501][501], visit[501][501];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int dfs(int x, int y)
{
    if (visit[x][y])
    {
        return visit[x][y];
    }

    int ret = 1;
    for (int k = 0; k < 4; ++k)
    {
        int xx = x + dx[k], yy = y + dy[k];
        if (xx < 0 || xx >= N || yy < 0 || yy >= N)
        {
            continue;
        }

        if (F[xx][yy] > F[x][y])
        {
            ret = max(ret, dfs(xx, yy) + 1);
        }
    }

    return visit[x][y] = ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> F[i][j];
        }
    }

    int ans = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            ans = max(ans, dfs(i, j));
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << visit[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    cout << ans;

    return 0;
}
