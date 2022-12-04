// 221204_BOJ_1802

#include <iostream>
#include <string>

using namespace std;

int T;
string input;
bool answer;

void solve(int idx)
{
    if (idx == 1)
    {
        answer = true;
        return;
    }

    int i = idx / 2;
    bool pos = true;
    for (int k = 1; k <= i; ++k)
    {
        if (input[i - k] == input[i + k])
        {
            pos = false;
            break;
        }
    }
    if (pos)
    {
        solve(i);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> input; // 1: out    2: in

        answer = false;
        solve(input.length());
        if (answer)
        {
            cout << "YES\n";
        }
        else
        {
            cout << "NO\n";
        }
    }

    return 0;
}
