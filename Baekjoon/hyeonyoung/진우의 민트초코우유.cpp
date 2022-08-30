// 220826_BOJ_20208

#include <iostream>

using namespace std;

int N, M, H;
char town[11][11];
pair<int, int> house, milk[11];
int milk_cnt = 0, ans = 0;
bool drink[11];

int dis(pair<int, int> now, pair<int, int> next)
{
    return abs(now.first - next.first) + abs(now.second - next.second);
}

void solve(int cnt, int hp, pair<int, int> now)
{
    if (dis(now, house) <= hp)
    {
        ans = max(ans, cnt);
    }

    for (int i = 0; i < milk_cnt; ++i)
    {
        if (drink[i])
        {
            continue;
        }

        int d = dis(now, milk[i]);
        if (d <= hp)
        {
            drink[i] = true;
            solve(cnt + 1, hp - d + H, milk[i]);
            drink[i] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> H;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> town[i][j];
            if (town[i][j] == '1')
            {
                house = {i, j};
            }
            else if (town[i][j] == '2')
            {
                milk[milk_cnt++] = {i, j};
            }
        }
    }

    solve(0, M, house);

    cout << ans;

    return 0;
}
