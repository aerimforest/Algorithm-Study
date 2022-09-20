// 220920_BOJ_1456

#include <iostream>

using namespace std;

long long A, B;
const int MAX = 10000000;
bool notPrime[MAX + 1];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (long long i = 2; i * i <= MAX; ++i)
    {
        if (notPrime[i])
        {
            continue;
        }
        for (long long j = i * i; j <= MAX; j += i)
        {
            notPrime[j] = true;
        }
    }

    cin >> A >> B;
    int ans = 0;
    for (long long i = 2; i * i <= B; ++i)
    {
        if (!notPrime[i])
        {
            for (long long j = i * i; j <= B; j *= i)
            {
                if (j >= A)
                {
                    ans++;
                }
                if (j > B / i)
                {
                    break;
                }
            }
        }
    }
    cout << ans;

    return 0;
}
