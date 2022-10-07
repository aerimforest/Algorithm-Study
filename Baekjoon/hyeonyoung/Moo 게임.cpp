// 221007_BOJ_5904

#include <iostream>

using namespace std;

int S[30], N;
char ans = '\0';

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i < 29; ++i)
    {
        S[i] = S[i - 1] * 2 + i + 2;
    }
    // for (int i = 0; i < 29; ++i)
    // {
    //     cout << S[i] << " ";
    // }
    // cout << "\n";

    cin >> N;
    while (ans == '\0')
    {
        int idx;
        for (idx = 28; idx >= 0; --idx)
        {
            if (S[idx] < N)
            {
                break;
            }
        }

        if (N > S[idx] + idx + 3)
        {
            N -= S[idx] + idx + 3;
            idx--;
        }
        else
        {
            N -= S[idx];
            if (N == 1)
            {
                ans = 'm';
            }
            else
            {
                ans = 'o';
            }
            break;
        }
    }

    cout << ans;

    return 0;
}
