// 220919_BOJ_20061

#include <iostream>

using namespace std;

int N, ans = 0;
bool red[4][4], blue[4][6], green[6][4];

void print()
{
    for (int i = 0; i < 4; ++i)
    {
        for (int j = 0; j < 4; ++j)
        {
            cout << red[i][j] << " ";
        }
        for (int j = 0; j < 6; ++j)
        {
            cout << blue[i][j] << " ";
        }
        cout << "\n";
    }
    for (int i = 0; i < 6; ++i)
    {
        for (int j = 0; j < 4; ++j)
        {
            cout << green[i][j] << " ";
        }
        cout << "\n";
    }
    cout << "\n";
}

void block(int t, int x, int y)
{
    // 블록 추가
    // 1X1 - (x,y)
    if (t == 1)
    {
        // blue
        int i = x, j = 0;
        for (; j < 5; ++j)
        {
            if (blue[i][j + 1])
            {
                blue[i][j] = true;
                break;
            }
        }
        if (j == 5)
        {
            blue[i][j] = true;
        }

        // green
        i = 0, j = y;
        for (; i < 5; ++i)
        {
            if (green[i + 1][j])
            {
                green[i][j] = true;
                break;
            }
        }
        if (i == 5)
        {
            green[i][j] = true;
        }
    }
    // 1X2 - (x,y) (x,y+1)
    else if (t == 2)
    {
        // blue
        int i = x, j = 1;
        for (; j < 5; ++j)
        {
            if (blue[i][j + 1])
            {
                blue[i][j - 1] = blue[i][j] = true;
                break;
            }
        }
        if (j == 5)
        {
            blue[i][j - 1] = blue[i][j] = true;
        }

        // green
        i = 0, j = y;
        for (; i < 5; ++i)
        {
            if (green[i + 1][j] || green[i + 1][j + 1])
            {
                green[i][j] = green[i][j + 1] = true;
                break;
            }
        }
        if (i == 5)
        {
            green[i][j] = green[i][j + 1] = true;
        }
    }
    // 2X1 - (x,y) (x+1,y)
    else if (t == 3)
    {
        // blue
        int i = x, j = 0;
        for (; j < 5; ++j)
        {
            if (blue[i][j + 1] || blue[i + 1][j + 1])
            {
                blue[i][j] = blue[i + 1][j] = true;
                break;
            }
        }
        if (j == 5)
        {
            blue[i][j] = blue[i + 1][j] = true;
        }
        // green
        i = 1, j = y;
        for (; i < 5; ++i)
        {
            if (green[i + 1][j])
            {
                green[i - 1][j] = green[i][j] = true;
                break;
            }
        }
        if (i == 5)
        {
            green[i - 1][j] = green[i][j] = true;
        }
    }
    // 행, 열 확인
    // blue
    for (int j = 5; j >= 0; --j)
    {
        bool chk = true;
        for (int i = 0; i < 4; ++i)
        {
            chk &= blue[i][j];
        }
        if (chk)
        {
            ans++;
            for (int x = 0; x < 4; ++x)
            {
                for (int y = j; y > 0; --y)
                {
                    blue[x][y] = blue[x][y - 1];
                }
                blue[x][0] = false;
            }
            j++;
        }
    }
    // green
    for (int i = 5; i >= 0; --i)
    {
        bool chk = true;
        for (int j = 0; j < 4; ++j)
        {
            chk &= green[i][j];
        }
        if (chk)
        {
            ans++;
            for (int y = 0; y < 4; ++y)
            {
                for (int x = i; x > 0; --x)
                {
                    green[x][y] = green[x - 1][y];
                }
                green[0][y] = false;
            }
            i++;
        }
    }

    // 0,1
    // blue
    for (int j = 0; j < 2; ++j)
    {
        bool chk = false;
        for (int i = 0; i < 4; ++i)
        {
            chk |= blue[i][j];
        }
        if (chk)
        {
            for (int x = 0; x < 4; ++x)
            {
                for (int y = 5; y > 0; --y)
                {
                    blue[x][y] = blue[x][y - 1];
                }
                blue[x][0] = false;
            }
            j--;
        }
    }
    // green
    for (int i = 0; i < 2; ++i)
    {
        bool chk = false;
        for (int j = 0; j < 4; ++j)
        {
            chk |= green[i][j];
        }
        if (chk)
        {
            for (int y = 0; y < 4; ++y)
            {
                for (int x = 5; x > 0; --x)
                {
                    green[x][y] = green[x - 1][y];
                }
                green[0][y] = false;
            }
            i--;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int n = 0; n < N; ++n)
    {
        int t, x, y;
        cin >> t >> x >> y;

        block(t, x, y);
    }

    int cnt = 0;
    for (int i = 0; i < 4; ++i)
    {
        for (int j = 0; j < 6; ++j)
        {
            cnt += blue[i][j] + green[j][i];
        }
    }

    cout << ans << "\n";
    cout << cnt << "\n";

    return 0;
}
