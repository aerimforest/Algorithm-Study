// 220905_BOJ_19583

#include <iostream>
#include <string>
#include <map>

using namespace std;

pair<int, int> S, E, Q;
map<string, bool> M;

pair<int, int> hhmm(string str)
{
    return {(str[0] - '0') * 10 + str[1] - '0', (str[3] - '0') * 10 + str[4]};
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s, e, q;
    cin >> s >> e >> q;

    S = hhmm(s), E = hhmm(e), Q = hhmm(q);

    string t, name;

    while (1)
    {
        cin >> t >> name;
        if (cin.eof())
        {
            break;
        }

        pair<int, int> T = hhmm(t);
        // 시작
        if (T.first < S.first || (T.first == S.first && T.second <= S.second))
        {
            M[name] = true;
        }
        // 중간
        else if (T.first < E.first || (T.first == E.first && T.second < E.second))
        {
            continue;
        }
        // 끝
        else if (T.first < Q.first || (T.first == Q.first && T.second <= Q.second))
        {
            if (M.find(name) != M.end())
            {
                M[name] = false;
            }
        }
        // 끝끝
        else
        {
            continue;
        }
    }

    int ans = 0;
    for (auto x : M)
    {
        if (x.second == false)
        {
            ans++;
        }
    }
    cout << ans;

    return 0;
}
