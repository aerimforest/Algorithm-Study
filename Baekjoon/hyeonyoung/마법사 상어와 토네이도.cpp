// 221014_BOJ_20057

#include <iostream>

using namespace std;

int N, A[500][500];
int ans = 0;

int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};

void wind(int x, int y, int d)
{
    int xx = x + dx[d], yy = y + dy[d];

    int sand = A[xx][yy];

    int r, c;
    // 1
    r = x + dy[d];
    c = y + dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 1 / 100;
    }
    else
    {
        A[r][c] += sand * 1 / 100;
    }
    A[xx][yy] -= sand * 1 / 100;

    r = x - dy[d];
    c = y - dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 1 / 100;
    }
    else
    {
        A[r][c] += sand * 1 / 100;
    }
    A[xx][yy] -= sand * 1 / 100;

    // 2
    r = xx + 2 * dy[d];
    c = yy + 2 * dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 2 / 100;
    }
    else
    {
        A[r][c] += sand * 2 / 100;
    }
    A[xx][yy] -= sand * 2 / 100;

    r = xx - 2 * dy[d];
    c = yy - 2 * dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 2 / 100;
    }
    else
    {
        A[r][c] += sand * 2 / 100;
    }
    A[xx][yy] -= sand * 2 / 100;

    // 7
    r = xx + dy[d];
    c = yy + dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 7 / 100;
    }
    else
    {
        A[r][c] += sand * 7 / 100;
    }
    A[xx][yy] -= sand * 7 / 100;

    r = xx - dy[d];
    c = yy - dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 7 / 100;
    }
    else
    {
        A[r][c] += sand * 7 / 100;
    }
    A[xx][yy] -= sand * 7 / 100;

    // 10
    r = xx + dx[d] + dy[d];
    c = yy + dy[d] + dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 10 / 100;
    }
    else
    {
        A[r][c] += sand * 10 / 100;
    }
    A[xx][yy] -= sand * 10 / 100;

    r = xx + dx[d] - dy[d];
    c = yy + dy[d] - dx[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 10 / 100;
    }
    else
    {
        A[r][c] += sand * 10 / 100;
    }
    A[xx][yy] -= sand * 10 / 100;

    // 5
    r = xx + 2 * dx[d];
    c = yy + 2 * dy[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += sand * 5 / 100;
    }
    else
    {
        A[r][c] += sand * 5 / 100;
    }
    A[xx][yy] -= sand * 5 / 100;

    // alpha
    r = xx + dx[d];
    c = yy + dy[d];
    if (r < 0 || r >= N || c < 0 || c >= N)
    {
        ans += A[xx][yy];
    }
    else
    {
        A[r][c] += A[xx][yy];
    }
    A[xx][yy] = 0;
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
            cin >> A[i][j];
        }
    }

    int r = N / 2, c = N / 2;
    int dir = 0;
    for (int cnt = 1; cnt < N; ++cnt)
    {
        for (int k = 0; k < cnt; ++k)
        {
            wind(r, c, dir);

            r += dx[dir];
            c += dy[dir];
        }
        dir = (dir + 1) & 3;

        for (int k = 0; k < cnt; ++k)
        {
            wind(r, c, dir);

            r += dx[dir];
            c += dy[dir];
        }
        dir = (dir + 1) & 3;
    }
    for (int k = 1; k < N; ++k)
    {
        wind(r, c, dir);

        r += dx[dir];
        c += dy[dir];
    }

    cout << ans;

    return 0;
}
