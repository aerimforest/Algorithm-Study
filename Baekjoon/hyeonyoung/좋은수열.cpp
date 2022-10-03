// 221003_BOJ_2661

#include <iostream>

using namespace std;

int N;
char answer[81];
bool chk = false;

bool repeat(int idx)
{
    for (int i = idx - 1; i >= 0; --i)
    {
        if (answer[i] == answer[idx])
        {
            int j;
            for (j = 1; i - j >= 0 && j < idx - i; ++j)
            {
                if (answer[i - j] != answer[idx - j])
                {
                    break;
                }
            }
            if (i - j >= -1 && j == idx - i)
            {
                return false;
            }
        }
    }
    return true;
}

void solve(int idx, int before)
{
    if (chk)
        return;

    if (idx == N)
    {
        chk = true;
        for (int i = 0; i < N; ++i)
        {
            cout << answer[i];
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= 3; ++i)
    {
        if (i == before)
        {
            continue;
        }

        answer[idx] = '0' + i;
        if (repeat(idx))
        {
            solve(idx + 1, i);
        }
        answer[idx] = '\0';
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    for (int i = 1; i <= 3; ++i)
    {
        answer[0] = '0' + i;
        solve(1, i);
        answer[0] = '\0';
    }

    return 0;
}
