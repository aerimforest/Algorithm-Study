// 221206_BOJ_3079

#include <iostream>

using namespace std;

int N, M;
long long T[100002];
long long l = 1, r = (long long)1e10, answer;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> T[i];
        r = min(r, T[i]);
    }
    r *= M;
    answer = r;

    while (l <= r)
    {
        long long m = (l + r) / 2;

        long long cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            cnt += (m / T[i]);
        }
        if (cnt > 0 && cnt < M)
        {
            l = m + 1;
        }
        else
        {
            answer = min(answer, m);
            r = m - 1;
        }
    }
    cout << answer;

    return 0;
}
