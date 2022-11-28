// 221029_BOJ_4195

#include <iostream>
#include <map>
#include <string>

using namespace std;

int T, F;
map<string, pair<string, int>> fr;

string findFr(string s)
{
    if (fr.find(s) == fr.end())
    {
        fr[s] = {s, 1};
        return s;
    }

    if (fr[s].first == s)
    {
        return s;
    }

    return fr[s].first = findFr(fr[s].first);
}
int unionFr(string a, string b)
{
    string aa = findFr(a), bb = findFr(b);

    if (aa == bb)
    {
        return fr[aa].second;
    }

    fr[aa].first = bb;
    fr[bb].second += fr[aa].second;

    return fr[bb].second;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        fr = {};
        cin >> F;

        while (F-- > 0)
        {
            string a, b;
            cin >> a >> b;

            cout << unionFr(a, b) << "\n";
        }
    }

    return 0;
}
