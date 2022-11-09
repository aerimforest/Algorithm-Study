// 221107_BOJ_11501

#include <iostream>

using namespace std;

int T, N, price[1000001];
long long answer;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        answer = 0;

        cin >> N;
        for (int i = 0; i < N; ++i)
        {
            cin >> price[i];
        }

        int cur = price[N - 1];
        for (int i = N - 2; i >= 0; --i)
        {
            if (price[i] <= cur)
            {
                answer += cur - price[i];
            }
            else
            {
                cur = price[i];
            }
        }
        cout << answer << "\n";
    }

    return 0;
}
