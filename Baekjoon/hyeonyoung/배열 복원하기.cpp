// 221027_BOJ_16967

#include <iostream>

using namespace std;

int H, W, X, Y;
int A[301][301], B[601][601];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> H >> W >> X >> Y;
    for (int i = 0; i < H + X; ++i)
    {
        for (int j = 0; j < W + Y; ++j)
        {
            cin >> B[i][j];
        }
    }

    for (int i = 0; i < H; ++i)
    {
        for (int j = 0; j < W; ++j)
        {
            if (i < X || j < Y)
            {
                A[i][j] = B[i][j];
            }
        }
    }

    for (int i = X; i < H; ++i)
    {
        for (int j = Y; j < W; ++j)
        {
            A[i][j] = B[i][j] - A[i - X][j - Y];
        }
    }

    for (int i = 0; i < H; ++i)
    {
        for (int j = 0; j < W; ++j)
        {
            cout << A[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
