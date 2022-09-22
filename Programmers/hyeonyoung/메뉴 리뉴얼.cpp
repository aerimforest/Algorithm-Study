#include <string>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> orders, vector<int> course)
{
    // init
    int order[21], olen = orders.size();
    for (int i = 0; i < olen; ++i)
    {
        order[i] = 0;
        for (char c : orders[i])
        {
            order[i] |= (1 << (c - 'A'));
        }
    }
    bool lens[11];
    memset(lens, false, sizeof(lens));
    for (int c : course)
    {
        lens[c] = 1;
    }

    vector<string> answer;
    int priority[11];
    memset(priority, 0, sizeof(priority));
    vector<int> memo[11];
    for (int x = 1; x < (1 << 26); ++x)
    {
        int len = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (x & (1 << i))
                len++;
        }
        if (lens[len])
        {
            int cnt = 0;
            for (int i = 0; i < olen; ++i)
            {
                if ((order[i] & x) == x)
                {
                    cnt++;
                }
            }
            if (cnt < 2)
            {
                continue;
            }
            if (priority[len] < cnt)
            {
                priority[len] = cnt;
                memo[len] = {x};
            }
            else if (priority[len] == cnt)
            {
                memo[len].push_back(x);
            }
        }
    }
    for (int c : course)
    {
        for (int x : memo[c])
        {
            string s = "";
            for (int i = 0; i < 26; ++i)
            {
                if (x & (1 << i))
                {
                    s = s + char('A' + i);
                }
            }
            answer.push_back(s);
        }
    }
    sort(answer.begin(), answer.end());

    return answer;
}
