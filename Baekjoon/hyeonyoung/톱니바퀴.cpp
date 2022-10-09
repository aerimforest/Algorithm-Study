// 221008_BOJ_14891

#include <iostream>

using namespace std;

char gear[4][9];
int K, p[4] = {0, 0, 0, 0};

void rotate(int n, int d)
{
    int r[4] = {0, 0, 0, 0};
    r[n] = d;
    for (int i = n - 1; i >= 0; --i)
    {
        if (gear[i + 1][(p[i + 1] + 6) % 8] == gear[i][(p[i] + 2) % 8])
        {
            break;
        }
        r[i] = -r[i + 1];
    }
    for (int i = n + 1; i < 4; ++i)
    {
        if (gear[i - 1][(p[i - 1] + 2) % 8] == gear[i][(p[i] + 6) % 8])
        {
            break;
        }
        r[i] = -r[i - 1];
    }

    for (int i = 0; i < 4; ++i)
    {
        p[i] = (p[i] + r[i] + 8) % 8;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 4; ++i)
    {
        cin >> gear[i];
    }
    cin >> K;
    for (int i = 0; i < K; ++i)
    {
        int n, d;
        cin >> n >> d;

        rotate(n - 1, -d);
    }

    int ans = 0;
    for (int i = 0; i < 4; ++i)
    {
        if (gear[i][p[i]] == '1')
        {
            ans |= (1 << i);
        }
    }
    cout << ans;

    return 0;
}
