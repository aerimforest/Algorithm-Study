// 220917_BOJ_2042

#include <iostream>

using namespace std;

int N, M, K;
long long indexTree[1 << 21];
int start;

void change(int idx, long long x)
{
    indexTree[start + idx] = x;
    idx = (start + idx) / 2;
    while (idx > 0)
    {
        indexTree[idx] = indexTree[idx * 2] + indexTree[idx * 2 + 1];
        idx /= 2;
    }
}
long long getSum(int x, int y)
{
    long long ret = 0;
    x += start, y += start;
    while (x < y)
    {
        if (x & 1)
        {
            ret += indexTree[x];
            x = (x + 1) / 2;
        }
        else
        {
            x = x / 2;
        }

        if (y & 1)
        {
            y = y / 2;
        }
        else
        {
            ret += indexTree[y];
            y = (y - 1) / 2;
        }
    }
    if (x == y)
    {
        ret += indexTree[x];
    }

    return ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    for (int i = 0;; ++i)
    {
        if ((1 << i) >= N)
        {
            start = (1 << i);
            break;
        }
    }

    for (int i = 0; i < N; ++i)
    {
        cin >> indexTree[start + i];
    }
    for (int i = start - 1; i > 0; --i)
    {
        indexTree[i] = indexTree[i * 2] + indexTree[i * 2 + 1];
    }

    for (int k = M + K; k > 0; --k)
    {
        long long a, b, c;
        cin >> a >> b >> c;

        if (a == 1)
        {
            change(b - 1, c);
        }
        else
        {
            cout << getSum(b - 1, c - 1) << "\n";
        }

        // for (int i = 1; i < start * 2; i *= 2)
        // {
        //     for (int j = i; j < i * 2; ++j)
        //     {
        //         cout << indexTree[j] << " ";
        //     }
        //     cout << "\n";
        // }
    }

    return 0;
}
