// 221126_BOJ_2064

#include <iostream>
#include <string>
#include <bitset>

using namespace std;

int N;
int network[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        string input;
        cin >> input;

        int ip = 0, n = 0;
        for (char c : input)
        {
            if (c == '.')
            {
                ip <<= 8;
                ip |= n;
                n = 0;
            }
            else
            {
                n = n * 10 + c - '0';
            }
        }
        ip <<= 8;
        ip |= n;
        n = 0;

        network[i] = ip;

        // cout << bitset<32>(ip) << "\n";
    }

    int x = network[0], y = network[0];
    for (int i = 1; i < N; ++i)
    {
        x &= network[i];
        y |= network[i];
    }
    // cout << "\n"
    //      << bitset<32>(x) << "\n"
    //      << bitset<32>(y) << "\n";

    int M = 0;
    for (int m = 0; m < 32; ++m)
    {
        if ((x & (1 << m)) != (y & (1 << m)))
        {
            M = m + 1;
        }
    }
    // cout << M << "\n";

    // cout << bitset<32>((network[0] >> M) << M) << "\n";
    int address = (M == 32 ? 0 : ((network[0] >> M) << M));
    cout << ((address >> 24) & 255);
    for (int i = 2; i >= 0; --i)
    {
        cout << "." << ((address >> (i * 8)) & 255);
    }
    cout << "\n";
    // cout << bitset<32>(0xffffffff << M) << "\n";
    int mask = (M == 32 ? 0 : (0xffffffff << M));
    cout << ((mask >> 24) & 255);
    for (int i = 2; i >= 0; --i)
    {
        cout << "." << ((mask >> (i * 8)) & 255);
    }

    return 0;
}
