// 220824_BOJ_1062

#include <iostream>
#include <cstring>

using namespace std;

int N, K;
char str[20];
int words[51], ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    // antic
    int alphabet = 0;
    char fix[6] = {'a', 'n', 't', 'i', 'c'};
    for (int i = 0; i < 5; ++i)
    {
        alphabet |= (1 << (fix[i] - 'a'));
    }

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> str;
        int l = strlen(str);

        words[i] = alphabet;
        for (int j = 4; j < l - 4; ++j)
        {
            words[i] |= (1 << (str[j] - 'a'));
        }
    }

    for (int x = 0; x < (1 << 26); ++x)
    {
        // antic 없을 때
        if ((x & alphabet) != alphabet)
        {
            continue;
        }

        // K개 넘게 골랐을 때
        int cnt = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (x & (1 << i))
            {
                cnt++;
            }
        }
        if (cnt > K)
        {
            continue;
        }

        // 배울 수 있는 단어 개수
        // for (int i = 0; i < 26; ++i)
        // {
        //     if (x & (1 << i))
        //     {
        //         cout << char('a' + i) << " ";
        //     }
        // }
        cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            if ((x & words[i]) == words[i])
            {
                cnt++;
            }
        }
        // cout << cnt << "\n";

        ans = max(ans, cnt);
    }

    cout << ans;

    return 0;
}
