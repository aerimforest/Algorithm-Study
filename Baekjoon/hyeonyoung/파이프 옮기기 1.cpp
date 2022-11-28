// 221023_BOJ_17070

#include <iostream>

using namespace std;

int N, house[17][17];
int cnt[17][17][3]; // 가로, 세로, 대각선

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> house[i][j];
        }
    }

    cnt[0][1][0] = 1;
    for (int j = 2; j < N; ++j)
    {
        if (house[0][j])
        {
            continue;
        }
        cnt[0][j][0] = cnt[0][j - 1][0] + cnt[0][j - 1][2];
    }
    for (int i = 1; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (house[i][j])
            {
                continue;
            }

            // 가로
            if (j - 1 >= 0)
            {
                cnt[i][j][0] = cnt[i][j - 1][0] + cnt[i][j - 1][2];
            }
            // 세로
            if (i - 1 >= 0)
            {
                cnt[i][j][1] = cnt[i - 1][j][1] + cnt[i - 1][j][2];
            }
            // 대각선
            if (i - 1 >= 0 && j - 1 >= 0 && house[i - 1][j] == 0 && house[i][j - 1] == 0)
            {
                cnt[i][j][2] = cnt[i - 1][j - 1][0] + cnt[i - 1][j - 1][1] + cnt[i - 1][j - 1][2];
            }
        }
    }

    cout << cnt[N - 1][N - 1][0] + cnt[N - 1][N - 1][1] + cnt[N - 1][N - 1][2];

    return 0;
}
