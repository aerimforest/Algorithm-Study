// 221022_BOJ_12919

#include <iostream>
#include <string>

using namespace std;

string S, T;
int slen = 0;
bool ans = false;

void solve(string t)
{
    int tlen = t.length();
    if (tlen == slen)
    {
        if (t.compare(S) == 0)
        {
            ans = true;
        }
        return;
    }

    if (t[tlen - 1] == 'A')
    {
        solve(t.substr(0, tlen - 1));
    }
    if (t[0] == 'B')
    {
        string B = "";
        for (int i = tlen - 1; i > 0; --i)
        {
            B.push_back(t[i]);
        }
        solve(B);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S >> T;
    slen = S.length();

    solve(T);

    cout << ans;

    return 0;
}
