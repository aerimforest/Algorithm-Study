// 221011_BOJ_16637

#include <iostream>
#include <string>

using namespace std;

int N;
long long ans = -((long long)1 << 32);
string ex;

long long cal(int a, int b, char c)
{
    if (c == '+')
    {
        return a + b;
    }
    else if (c == '-')
    {
        return a - b;
    }
    else if (c == '*')
    {
        return a * b;
    }
    return 0;
}

void solve(int idx, int state)
{
    if (idx > N)
    {
        long long sum = ex[0] - '0';
        int i;
        for (i = 2; i < N - 1; i += 2)
        {
            if (state & (1 << (i / 2)))
            {
                long long tmp = cal(ex[i] - '0', ex[i + 2] - '0', ex[i + 1]);
                sum = cal(sum, tmp, ex[i - 1]);

                i += 2;
            }
            else
            {
                sum = cal(sum, ex[i] - '0', ex[i - 1]);
            }
        }
        if (i == N - 1)
        {
            sum = cal(sum, ex[i] - '0', ex[i - 1]);
        }

        ans = max(ans, sum);

        return;
    }

    solve(idx + 2, state);
    if ((state & (1 << (idx / 2 - 1))) == 0)
    {
        solve(idx + 2, (state | (1 << (idx / 2))));
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    cin >> ex;

    solve(3, 0);

    cout << ans;

    return 0;
}
