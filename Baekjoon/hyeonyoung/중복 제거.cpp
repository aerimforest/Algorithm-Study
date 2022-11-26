// 221126_BOJ_13701

#include <iostream>

using namespace std;

int chk[(1 << 20) + 1];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int x;
    while (cin >> x)
    {

        if (chk[x / 32] & (1 << (x % 32)))
        {
            continue;
        }
        else
        {
            chk[x / 32] = chk[x / 32] | (1 << (x % 32));
            cout << x << " ";
        }
    }

    return 0;
}
