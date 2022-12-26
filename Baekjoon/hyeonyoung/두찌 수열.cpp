// 221226_BOJ_8922

#include <iostream>

using namespace std;

int T, N, A[1001][16];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> N;
        for (int i = 0; i < N; ++i)
        {
            cin >> A[0][i];
        }

        for (int k = 0;; ++k)
        {
            // zero
            bool zero = true;
            for (int i = 0; i < N; ++i)
            {
                if (A[k][i] != 0)
                {
                    zero = false;
                    break;
                }
            }
            if (zero)
            {
                cout << "ZERO\n";
                break;
            }

            // loop
            bool loop = false;
            for (int kk = k - 1; kk >= 0; --kk)
            {
                int same = true;
                for (int i = 0; i < N; ++i)
                {
                    if (A[kk][i] != A[k][i])
                    {
                        same = false;
                        break;
                    }
                }

                if (same)
                {
                    loop = true;
                    break;
                }
            }
            if (loop)
            {
                cout << "LOOP\n";
                break;
            }

            // next
            for (int i = 0; i < N - 1; ++i)
            {
                A[k + 1][i] = abs(A[k][i] - A[k][i + 1]);
            }
            A[k + 1][N - 1] = abs(A[k][N - 1] - A[k][0]);
        }
    }

    return 0;
}
