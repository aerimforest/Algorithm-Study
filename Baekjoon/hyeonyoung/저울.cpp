// 221010_BOJ_2437

#include <iostream>
#include <algorithm>

using namespace std;

int N, W[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> W[i];
    }
    sort(W, W + N);

    int ans = 0;
    for (int i = 0; i < N; ++i)
    {
        if (W[i] > ans + 1)
        {
            break;
        }
        ans += W[i];
    }

    cout << ans + 1;

    return 0;
}
