// 221216_BOJ_2023

#include <iostream>

using namespace std;

int N;

bool isPrime(int x)
{
    if (x < 2)
    {
        return false;
    }
    for (int i = 2; i * i <= x; ++i)
    {
        if (x % i == 0)
        {
            return false;
        }
    }
    return true;
}

void solve(int x, int len)
{
    if (len == N)
    {
        cout << x << "\n";
        return;
    }

    for (int i = 0; i < 10; ++i)
    {
        if (isPrime(x * 10 + i))
        {
            solve(x * 10 + i, len + 1);
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    solve(0, 0);

    return 0;
}
