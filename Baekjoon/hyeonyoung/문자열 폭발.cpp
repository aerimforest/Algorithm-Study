// 220905_BOJ_9935

#include <iostream>
#include <string>
#include <stack>

using namespace std;

string str, bomb;
stack<pair<char, int>> S;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> str >> bomb;

    int blen = bomb.length() - 1;
    for (char x : str)
    {
        if (S.empty())
        {
            if (x == bomb[0])
            {
                S.push({x, 0});
            }
            else
            {
                S.push({x, -1});
            }
        }
        else if (x == bomb[S.top().second + 1])
        {
            S.push({x, S.top().second + 1});
        }
        else if (x == bomb[0])
        {
            S.push({x, 0});
        }
        else
        {
            S.push({x, -1});
        }

        // cout << S.top().first << " " << S.top().second << "\n";

        if (S.top().second == blen)
        {
            for (int i = 0; i <= blen; ++i)
            {
                S.pop();
            }
        }
    }

    char answer[1000002];
    int idx = S.size();
    if (idx == 0)
    {
        cout << "FRULA";
    }
    else
    {
        answer[idx--] = '\0';
        while (!S.empty() && idx >= 0)
        {
            answer[idx--] = S.top().first;
            S.pop();
        }
        cout << answer;
    }

    return 0;
}
