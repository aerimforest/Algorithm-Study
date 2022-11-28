// 221121_BOJ_2792

#include <iostream>

using namespace std;

int N, M, jew[300001];
int l = 1, r = 0, answer = 0x7fffffff;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        cin >> jew[i];
        r = max(r, jew[i]);
    }

    while (l <= r)
    {
        int mid = (l + r) / 2;

        int cnt = 0;
        for (int i = 0; i < M; ++i)
        {
            cnt += (jew[i] - 1) / mid + 1;
        }
        if (cnt > N)
        {
            l = mid + 1;
        }
        else
        {
            answer = min(answer, mid);
            r = mid - 1;
        }
    }
    cout << answer;

    return 0;
}
