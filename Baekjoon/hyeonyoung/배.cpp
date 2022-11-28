// 221029_BOJ_1092

#include <iostream>
#include <algorithm>

using namespace std;

int N, Crane[51], M, Box[10001];
bool moved[10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> Crane[i];
    }
    sort(Crane, Crane + N);
    cin >> M;
    for (int i = 0; i < M; ++i)
    {
        cin >> Box[i];
    }
    sort(Box, Box + M);

    int ans = 0;
    if (Box[M - 1] > Crane[N - 1])
    {
        ans = -1;
    }
    else
    {
        int cnt = 0;
        while (cnt < M)
        {
            ans++;
            int idx = M;
            for (int i = N - 1; i >= 0; --i)
            {
                for (idx--; idx >= 0; --idx)
                {
                    if (moved[idx])
                    {
                        continue;
                    }

                    if (Crane[i] >= Box[idx])
                    {
                        moved[idx] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
    }

    cout << ans;

    return 0;
}
