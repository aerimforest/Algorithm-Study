// 220902_BOJ_9996

#include <iostream>
#include <cstring>

using namespace std;

int N;
char pattern[102], input[102];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    cin >> pattern;
    int plen = strlen(pattern), star = -1;
    for (int i = 0; i < plen; ++i)
    {
        if (pattern[i] == '*')
        {
            star = i;
            break;
        }
    }

    for (int i = 0; i < N; ++i)
    {
        cin >> input;
        int ilen = strlen(input);
        bool ans = (ilen >= plen - 1);

        for (int j = 0; ans && j < star; ++j)
        {
            if (pattern[j] != input[j])
            {
                ans = false;
            }
        }
        for (int j = 1; ans && j < plen - star; ++j)
        {
            if (pattern[plen - j] != input[ilen - j])
            {
                ans = false;
            }
        }

        if (ans)
        {
            cout << "DA\n";
        }
        else
        {
            cout << "NE\n";
        }
    }

    return 0;
}
