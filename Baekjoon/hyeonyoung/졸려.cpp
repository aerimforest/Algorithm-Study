// 221124_BOJ_9519

#include <iostream>
#include <algorithm>

using namespace std;

int X, len;
string input, S;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> X;
    cin >> input;
    S = input;
    len = S.length();
    for (int x = 1; x <= X; ++x)
    {
        string tmp = "";
        int idx = 0;
        for (idx = 0; idx < len; idx += 2)
        {
            tmp += S[idx];
        }
        for (idx = (len % 2 ? len - 2 : len - 1); idx > 0; idx -= 2)
        {
            tmp += S[idx];
        }
        S = tmp;

        if (S == input)
        {
            X %= x;
            break;
        }
    }
    S = input;
    for (int x = 0; x < X; ++x)
    {
        string tmp = "";
        int idx = 0;
        for (idx = 0; idx < len; idx += 2)
        {
            tmp += S[idx];
        }
        for (idx = (len % 2 ? len - 2 : len - 1); idx > 0; idx -= 2)
        {
            tmp += S[idx];
        }
        S = tmp;
    }
    cout << S;

    return 0;
}
