// 221024_BOJ_9079

#include <iostream>

using namespace std;

int T, ans;
bool board[3][3], tmp[3][3];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        ans = 1000;
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                char c;
                cin >> c;

                board[i][j] = (c == 'H');
            }
        }

        for (int x = 0; x < (1 << 8); ++x)
        {
            for (int i = 0; i < 3; ++i)
            {
                for (int j = 0; j < 3; ++j)
                {
                    tmp[i][j] = board[i][j];
                }
            }

            int cnt = 0;
            // 행
            for (int i = 0; i < 3; ++i)
            {
                if (x & (1 << i))
                {
                    cnt++;

                    for (int k = 0; k < 3; ++k)
                    {
                        tmp[i][k] = !tmp[i][k];
                    }
                }
            }
            // 열
            for (int i = 3; i < 6; ++i)
            {
                if (x & (1 << i))
                {
                    cnt++;

                    for (int k = 0; k < 3; ++k)
                    {
                        tmp[k][i - 3] = !tmp[k][i - 3];
                    }
                }
            }
            // 대각선
            if (x & (1 << 6))
            {
                cnt++;

                for (int k = 0; k < 3; ++k)
                {
                    tmp[k][k] = !tmp[k][k];
                }
            }
            if (x & (1 << 7))
            {
                cnt++;

                for (int k = 0; k < 3; ++k)
                {
                    tmp[k][2 - k] = !tmp[k][2 - k];
                }
            }

            bool flg = tmp[0][0], same = true;
            for (int i = 0; i < 3 && same; ++i)
            {
                for (int j = 0; j < 3; ++j)
                {
                    if (tmp[i][j] != flg)
                    {
                        same = false;
                        break;
                    }
                }
            }
            if (same)
            {
                ans = min(ans, cnt);
            }
        }
        if (ans == 1000)
        {
            ans = -1;
        }
        cout << ans << "\n";
    }

    return 0;
}
