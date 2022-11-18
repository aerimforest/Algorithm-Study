// 221118_BOJ_1254

#include <iostream>
#include <string>

using namespace std;

string S;
int answer = 0x7fffffff;

bool solve(int idx)
{
    int l = idx, r = S.length() - 1;
    while (l < r)
    {
        if (S[l] != S[r])
        {
            return false;
        }
        l++;
        r--;
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S;
    int len = S.length();
    for (int i = 0; i < len; ++i)
    {
        if (solve(i))
        {
            answer = min(answer, len + i);
        }
    }

    cout << answer;

    return 0;
}
