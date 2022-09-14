// 220914_BOJ_21921

#include <iostream>

using namespace std;

int N, X, P[250001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> X;
    for (int i = 1; i <= N; ++i)
    {
        int x;
        cin >> x;
        P[i] = P[i - 1] + x;
    }

    int ans = -1, cnt = 0;
    for (int i = X; i <= N; ++i)
    {
        int sum = P[i] - P[i - X];
        if (sum > ans)
        {
            ans = sum;
            cnt = 1;
        }
        else if (sum == ans)
        {
            cnt++;
        }
    }

    if (ans > 0)
    {
        cout << ans << "\n"
             << cnt << "\n";
    }
    else
    {
        cout << "SAD\n";
    }

    return 0;
}
