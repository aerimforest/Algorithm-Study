// 221224_BOJ_6236

#include <iostream>

using namespace std;

int N, M, P[100001];
int l = 1, r = 0, answer = 0x7fffffff;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> P[i];
        l = max(l, P[i]);
        r += P[i];
    }

    while (l <= r)
    {
        int m = (l + r) / 2;

        int cnt = 0, cur = 0;
        for (int i = 0; i < N; ++i)
        {
            if (cur < P[i])
            {
                cnt++;
                cur = m;
            }

            cur -= P[i];
        }

        if (cnt <= M)
        {
            answer = min(answer, m);
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    cout << answer;

    return 0;
}
