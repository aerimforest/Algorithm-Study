// 221123_BOJ_20438

#include <iostream>

using namespace std;

int N, K, Q, M;
int sleep[5010]; // 1: 자는중 2: 출석
int cnt[5010];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> K >> Q >> M;
    for (int i = 0; i < K; ++i)
    {
        int x;
        cin >> x;
        sleep[x] = 1;
    }

    for (int i = 0; i < Q; ++i)
    {
        int x;
        cin >> x;
        if (sleep[x] == 0)
        {
            for (int j = x; j <= N + 2; j += x)
            {
                if (sleep[j] == 0)
                {
                    sleep[j] = 2;
                }
            }
        }
    }
    for (int i = 3; i <= N + 2; ++i)
    {
        cnt[i] = cnt[i - 1] + (sleep[i] != 2 ? 1 : 0);
    }

    for (int i = 0; i < M; ++i)
    {
        int x, y;
        cin >> x >> y;
        cout << cnt[y] - cnt[x - 1] << "\n";
    }

    return 0;
}
