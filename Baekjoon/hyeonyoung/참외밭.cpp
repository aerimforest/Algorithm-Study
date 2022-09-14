// 220910_BOJ_2477

#include <iostream>

using namespace std;

int K;
pair<int, int> field[7];
int dx[] = {0, 0, 0, 1, -1};
int dy[] = {0, 1, -1, 0, 0};
const int INF = 987654321;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K;
    for (int i = 1; i <= 6; ++i)
    {
        int x, y;
        cin >> x >> y;
        field[i] = {field[i - 1].first + dx[x] * y, field[i - 1].second + dy[x] * y};
    }

    int x[2] = {INF, -INF}, y[2] = {INF, -INF};
    for (int i = 0; i < 6; ++i)
    {
        x[0] = min(x[0], field[i].first);
        x[1] = max(x[1], field[i].first);
        y[0] = min(y[0], field[i].second);
        y[1] = max(y[1], field[i].second);
    }
    int ans = (x[1] - x[0]) * (y[1] - y[0]), idx;
    for (idx = 0; idx < 6; ++idx)
    {
        if (field[idx].first != x[0] && field[idx].first != x[1] && field[idx].second != y[0] && field[idx].second != y[1])
        {
            break;
        }
    }

    int tmp = field[(idx + 5) % 6].first - field[idx].first + field[(idx + 5) % 6].second - field[idx].second;
    tmp *= field[(idx + 1) % 6].first - field[idx].first + field[(idx + 1) % 6].second - field[idx].second;
    if (tmp < 0)
        tmp *= -1;
    ans -= tmp;

    cout << ans * K;

    return 0;
}
