// 220906_BOJ_21919

#include <iostream>

using namespace std;

int N, A;

bool prime[1000001];
const int MAX_A = 1000000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    // 소수 판정
    for (int i = 4; i <= MAX_A; i += 2)
    {
        prime[i] = true;
    }
    for (int i = 3; i * i <= MAX_A; i += 2)
    {
        if (prime[i])
            continue;

        for (int j = i * i; j <= MAX_A; j += i)
        {
            prime[j] = true;
        }
    }

    // for (int i = 2; i <= MAX_A; ++i)
    // {
    //     if (prime[i] == false)
    //     {
    //         cout << i << " ";
    //     }
    // }
    // cout << "\n";

    cin >> N;
    long long ans = 1;
    for (int i = 0; i < N; ++i)
    {
        cin >> A;
        if (!prime[A])
        {
            ans *= A;
            prime[A] = true;
        }
    }

    if (ans == 1)
    {
        ans = -1;
    }

    cout << ans;

    return 0;
}
