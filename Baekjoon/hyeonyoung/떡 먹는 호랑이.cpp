// 221105_BOJ_2502

#include <iostream>

using namespace std;

int D, K;
int memo[55];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    memo[1] = 1;
    memo[2] = 0;
    for (int i = 3; i <= 55; ++i)
    {
        memo[i] = memo[i - 2] + memo[i - 1];
    }

    cin >> D >> K;

    // X * A + Y * B = K
    int X = memo[D], Y = memo[D + 1];
    int A;
    for (A = 1;; ++A)
    {
        if ((K - X * A) > 0 && (K - X * A) % Y == 0)
        {
            cout << A << "\n"
                 << (K - X * A) / Y;
            break;
        }
    }

    return 0;
}
