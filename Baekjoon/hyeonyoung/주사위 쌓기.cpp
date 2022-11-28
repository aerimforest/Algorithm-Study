// 221105_BOJ_2116

#include <iostream>

using namespace std;

int N, dice[10001][6];
int opposite[6] = {5, 3, 4, 1, 2, 0};
int answer = 0;

int solve(int x)
{
    int ret = 0;
    for (int i = 0; i < 6; ++i)
    {
        if (i == x || i == opposite[x])
        {
            continue;
        }
        ret = max(ret, dice[0][i]);
    }

    x = opposite[x];
    for (int n = 1; n < N; ++n)
    {
        // 같은 숫자 찾기
        for (int i = 0; i < 6; ++i)
        {
            if (dice[n - 1][x] == dice[n][i])
            {
                x = i;
                break;
            }
        }

        // 옆면 중 가장 큰 수
        int big = 0;
        for (int i = 0; i < 6; ++i)
        {
            if (i == x || i == opposite[x])
            {
                continue;
            }
            big = max(big, dice[n][i]);
        }
        ret += big;

        x = opposite[x];
    }
    return ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < 6; ++j)
        {
            cin >> dice[i][j];
        }
    }

    for (int i = 0; i < 6; ++i)
    {
        answer = max(answer, solve(i));
    }
    cout << answer;

    return 0;
}
