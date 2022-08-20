// 220821_BOJ_15684

#include <iostream>

using namespace std;

int N, M, H, ladder[31][12]; // ladder[H][N]
int ans = 987654321;

void solve(int cnt, int idx)
{
    if (cnt > 3 || idx >= N * H || cnt >= ans)
    {
        return;
    }

    // i -> i 확인
    bool pos = true;
    for (int i = 1; i <= N; ++i)
    {
        int x = i;
        for (int j = 1; j <= H; ++j)
        {
            if (ladder[j][x - 1])
            {
                x--;
            }
            else if (ladder[j][x])
            {
                x++;
            }
        }
        if (i != x)
        {
            pos = false;
            break;
        }
    }
    if (pos)
    {
        ans = min(ans, cnt);
        return;
    }

    // 가로선 추가
    if (cnt == 3)
        return;
    while (idx < N * H)
    {
        int x = idx / N + 1, y = idx % N + 1;
        if (y != N && ladder[x][y] == 0 && ladder[x][y - 1] == 0 && ladder[x][y + 1] == 0)
        {
            ladder[x][y] = 1;
            solve(cnt + 1, idx + 1);
            ladder[x][y] = 0;
        }
        idx++;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> H;
    while (M-- > 0)
    {
        int a, b;
        cin >> a >> b;
        ladder[a][b] = 1;
    }

    solve(0, 0);
    if (ans > 3)
    {
        ans = -1;
    }

    cout << ans;

    return 0;
}
