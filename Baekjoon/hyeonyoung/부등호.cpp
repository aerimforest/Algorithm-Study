// 220915_BOJ_2529

#include <iostream>
#include <cstring>

using namespace std;

int K;
char inequality[10];
char ans[10];
bool chk[10], finish;

void solveMax(int cnt)
{
    if (finish)
    {
        return;
    }
    if (cnt == K)
    {
        finish = true;
        cout << ans << "\n";
        return;
    }

    // for (int i = 0; i <= cnt; ++i)
    // {
    //     cout << ans[i];
    // }
    // cout << "\n";

    int now = ans[cnt] - '0';
    if (inequality[cnt] == '<')
    {
        for (int next = 9; next > now; --next)
        {
            if (chk[next])
            {
                continue;
            }
            chk[next] = true;
            ans[cnt + 1] = '0' + next;
            solveMax(cnt + 1);
            chk[next] = false;
        }
    }
    else
    {
        for (int next = now - 1; next >= 0; --next)
        {
            if (chk[next])
            {
                continue;
            }
            chk[next] = true;
            ans[cnt + 1] = '0' + next;
            solveMax(cnt + 1);
            chk[next] = false;
        }
    }
}
void solveMin(int cnt)
{
    if (finish)
    {
        return;
    }
    if (cnt == K)
    {
        finish = true;
        cout << ans << "\n";
        return;
    }

    // for (int i = 0; i <= cnt; ++i)
    // {
    //     cout << ans[i];
    // }
    // cout << "\n";

    int now = ans[cnt] - '0';
    if (inequality[cnt] == '<')
    {
        for (int next = now + 1; next <= 9; ++next)
        {
            if (chk[next])
            {
                continue;
            }
            chk[next] = true;
            ans[cnt + 1] = '0' + next;
            solveMin(cnt + 1);
            chk[next] = false;
        }
    }
    else
    {
        for (int next = 0; next < now; ++next)
        {
            if (chk[next])
            {
                continue;
            }
            chk[next] = true;
            ans[cnt + 1] = '0' + next;
            solveMin(cnt + 1);
            chk[next] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K;
    for (int k = 0; k < K; ++k)
    {
        cin >> inequality[k];
    }

    memset(chk, 0, sizeof(chk));
    finish = false;
    for (int i = 9; i >= 0; --i)
    {
        ans[0] = '0' + i;
        chk[i] = true;
        solveMax(0);
        chk[i] = false;
    }
    memset(chk, 0, sizeof(chk));
    finish = false;
    for (int i = 0; i < 10; ++i)
    {
        ans[0] = '0' + i;
        chk[i] = true;
        solveMin(0);
        chk[i] = false;
    }

    return 0;
}
