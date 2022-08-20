// 220820_BOJ_17609

#include <iostream>
#include <string>

using namespace std;

int T;
string str;

int solve(int x, int y, bool remove)
{
    while (x < y)
    {
        if (str[x] == str[y])
        {
            x++;
            y--;
        }
        else if (!remove)
        {
            return min(solve(x + 1, y, true), solve(x, y - 1, true));
        }
        else
        {
            return 2;
        }
    }
    if (remove)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> str;

        cout << solve(0, str.length() - 1, false) << "\n";
    }

    return 0;
}
