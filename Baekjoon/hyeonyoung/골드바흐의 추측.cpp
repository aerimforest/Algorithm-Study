// 221230_BOJ_6588

#include <iostream>

using namespace std;

int N;
bool prime[1000001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 3; i * i <= 1000000; i += 2)
    {
        if (prime[i])
        {
            continue;
        }

        for (int j = i * i; j <= 1000000; j += i)
        {
            prime[j] = true;
        }
    }

    while (1)
    {
        cin >> N;
        if (N == 0)
        {
            break;
        }

        for (int a = 3; N - a >= 3; a += 2)
        {
            if (!prime[a] && !prime[N - a])
            {
                cout << N << " = " << a << " + " << N - a << "\n";
                break;
            }
        }
    }

    return 0;
}
