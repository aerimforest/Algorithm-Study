// 221119_BOJ_10830

#include <iostream>

using namespace std;

int N, A[6][6], answer[6][6], tmp[6][6];
long long B;
const int DIV = 1000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> B;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> A[i][j];
        }
        answer[i][i] = 1;
    }

    while (B > 0)
    {
        // B가 홀수
        if (B & 1)
        {
            for (int i = 0; i < N; ++i)
            {
                for (int j = 0; j < N; ++j)
                {
                    tmp[i][j] = 0;
                    for (int k = 0; k < N; ++k)
                    {
                        tmp[i][j] = (tmp[i][j] + answer[i][k] * A[k][j]) % DIV;
                    }
                }
            }
            for (int i = 0; i < N; ++i)
            {
                for (int j = 0; j < N; ++j)
                {
                    answer[i][j] = tmp[i][j];
                }
            }
        }

        // A => A*A
        B >>= 1;
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                tmp[i][j] = 0;
                for (int k = 0; k < N; ++k)
                {
                    tmp[i][j] = (tmp[i][j] + A[i][k] * A[k][j]) % DIV;
                }
            }
        }
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                A[i][j] = tmp[i][j];
            }
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cout << answer[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
