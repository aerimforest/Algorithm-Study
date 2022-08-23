// 220823_BOJ_13164

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K, H[300001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> H[i];
    }

    vector<int> dif;
    for (int i = 1; i < N; ++i)
    {
        dif.push_back(H[i] - H[i - 1]);
    }
    sort(dif.begin(), dif.end());

    long long ans = 0;
    for (int i = 0; i < N - K; ++i)
    {
        ans += dif[i];
    }
    cout << ans;

    return 0;
}
