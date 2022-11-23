// 221123_BOJ_13702

#include <iostream>

using namespace std;

int N, K, mak[10001];
int answer = 0;
int l = 1, r = 0x7fffffff;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> mak[i];
    }
    while (l <= r)
    {
        int mid = (l + (long long)r) / 2;

        int cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            cnt += mak[i] / mid;
        }

        if (cnt >= K)
        {
            answer = max(answer, mid);
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    cout << answer;

    return 0;
}
