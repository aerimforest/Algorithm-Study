// 221222_BOJ_16139

#include <iostream>
#include <string>

using namespace std;

string S;
int Q, count[200001][30];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S >> Q;
    int len = S.length();
    for (int i = 0; i < len; ++i)
    {
        for (int j = 'a'; j <= 'z'; ++j)
        {
            if (j == S[i])
            {
                count[i + 1][j - 'a'] = count[i][j - 'a'] + 1;
            }
            else
            {
                count[i + 1][j - 'a'] = count[i][j - 'a'];
            }
        }
    }

    // for (int i = 0; i < len; ++i)
    // {
    //     for (int j = 0; j < 26; ++j)
    //     {
    //         cout << count[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    for (int i = 0; i < Q; ++i)
    {
        char c;
        int l, r;
        cin >> c >> l >> r;

        cout << count[r + 1][c - 'a'] - count[l][c - 'a'] << "\n";
    }

    return 0;
}
