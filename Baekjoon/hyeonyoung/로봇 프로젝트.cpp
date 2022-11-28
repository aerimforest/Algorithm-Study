// 221122_BOJ_3649

#include <iostream>
#include <algorithm>

using namespace std;

int X, N, L[1000001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (cin >> X)
    {
        X *= 10000000;
        cin >> N;
        for (int i = 0; i < N; ++i)
        {
            cin >> L[i];
        }
        sort(L, L + N);

        int l = 0, r = N - 1;
        while (l < r)
        {
            if (X == L[l] + L[r])
            {
                break;
            }
            else if (X < L[l] + L[r])
            {
                r--;
            }
            else
            {
                l++;
            }
        }

        if (l < r && l >= 0 && r < N && X == L[l] + L[r])
        {
            cout << "yes " << L[l] << " " << L[r] << "\n";
        }
        else
        {
            cout << "danger\n";
        }
    }

    return 0;
}
