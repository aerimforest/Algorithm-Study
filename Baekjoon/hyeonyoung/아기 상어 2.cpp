// 230113_BOJ_17086

#include <iostream>

using namespace std;

int N, M, answer = 0, cnt = 0;
pair<int, int> shark[3000];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            int x;
            cin >> x;
            if (x == 1)
            {
                shark[cnt++] = {i, j};
            }
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            int safe_distance = 0x7fffffff;
            for (int k = 0; k < cnt; ++k)
            {
                int dx = abs(shark[k].first - i), dy = abs(shark[k].second - j);
                int d = min(dx, dy) + abs(dx - dy);
                safe_distance = min(safe_distance, d);
            }
            answer = max(answer, safe_distance);
        }
    }
    cout << answer;

    return 0;
}
