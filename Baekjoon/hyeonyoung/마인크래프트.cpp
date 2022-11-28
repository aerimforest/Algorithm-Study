// 221113_BOJ_18111

#include <iostream>

using namespace std;

int N, M, B, height[501][501];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> B;
    int high = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> height[i][j];
            high = max(high, height[i][j]);
        }
    }

    int T = 0x7fffffff, H = 0;
    for (int h = high; h >= 0; --h)
    {
        int b = B, t = 0;
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                if (height[i][j] > h)
                {
                    b += height[i][j] - h;
                    t += 2 * (height[i][j] - h);
                }
                else if (height[i][j] < h)
                {
                    b -= h - height[i][j];
                    t += h - height[i][j];
                }
            }
        }

        if (b >= 0)
        {
            if (T > t)
            {
                T = t;
                H = h;
            }
        }
    }
    cout << T << " " << H;

    return 0;
}
