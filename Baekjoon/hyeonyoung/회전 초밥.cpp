// 221013_BOJ_2531

#include <iostream>

using namespace std;

int N, D, K, C, belt[30001];
int count[3001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> D >> K >> C;
    for (int i = 0; i < N; ++i)
    {
        cin >> belt[i];
    }

    count[C] = 1;
    int kind = 1, ans = 0;
    for (int j = 0; j < K; ++j)
    {
        if (count[belt[j]]++ == 0)
        {
            kind++;
        }
    }
    if (count[C] > 0)
    {
        ans = kind;
    }

    for (int i = 1; i < N; ++i)
    {
        if (count[belt[i - 1]]-- == 1)
        {
            kind--;
        }

        int j = (i + K - 1) % N;
        if (count[belt[j]]++ == 0)
        {
            kind++;
        }

        ans = max(ans, kind);

        // cout << kind << "\t";
        // for (int i = 1; i <= D; ++i)
        // {
        //     if (count[i])
        //     {
        //         cout << i << " ";
        //     }
        // }
        // cout << "\n";
    }
    cout << ans;

    return 0;
}
