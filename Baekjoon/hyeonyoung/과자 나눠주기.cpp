// 221216_BOJ_16401

#include <iostream>

using namespace std;

int M, N;
long long L[1000001];
long long l = 1, r = 0, answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> L[i];
        r = max(r, L[i]);
    }

    while (l <= r)
    {
        long long m = (l + r) / 2;

        int cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            cnt += L[i] / m;
        }

        if (cnt >= M)
        {
            answer = max(answer, m);
            l = m + 1;
        }
        else
        {
            r = m - 1;
        }
    }

    cout << answer;

    return 0;
}
