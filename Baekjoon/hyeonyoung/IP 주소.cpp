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
                ip <<= 4;
                ip |= n;
                n = 0;
            }
            else
            {
                n = n * 10 + c - '0';
            }
        }
        ip <<= 4;
        ip |= n;
        n = 0;

        network[i] = ip;

        cout << bitset<32>(ip) << "\n";
    }

    int x = network[0], y = network[1];
    for (int i = 1; i < N; ++i)
    {
        x &= network[i];
        y |= network[i];
    }
    cout << "\n"
         << bitset<32>(x) << "\n"
         << bitset<32>(y) << "\n";
    int M;
    for (int M = 31; M >= 0; --M)
    {
    }

    return 0;
}
