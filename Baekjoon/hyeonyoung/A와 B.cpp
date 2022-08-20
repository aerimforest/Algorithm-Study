// 220820_BOJ_12904

#include <iostream>
#include <string>

using namespace std;

string S, T;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S >> T;

    int s_len = S.length();
    int x = 0, y = T.length() - 1;
    bool d = true; // true: ->, false: <-

    while (y - x + 1 > s_len)
    {
        if (d)
        {
            if (T[y] == 'A')
            {
                y--;
            }
            else
            {
                y--;
                d = !d;
            }
        }
        else
        {
            if (T[x] == 'A')
            {
                x++;
            }
            else
            {
                x++;
                d = !d;
            }
        }

        // // print
        // if (d)
        // {
        //     for (int i = x; i <= y; ++i)
        //     {
        //         cout << T[i];
        //     }
        //     cout << "\n";
        // }
        // else
        // {
        //     for (int i = y; i >= x; --i)
        //     {
        //         cout << T[i];
        //     }
        //     cout << "\n";
        // }
    }

    int ans = 1;
    if (d)
    {
        for (int i = x, j = 0; i <= y; ++i, ++j)
        {
            if (T[i] != S[j])
            {
                ans = 0;
                break;
            }
        }
    }
    else
    {
        for (int i = y, j = 0; i >= x; --i, ++j)
        {
            if (T[i] != S[j])
            {
                ans = 0;
                break;
            }
        }
    }
    cout << ans;

    return 0;
}
