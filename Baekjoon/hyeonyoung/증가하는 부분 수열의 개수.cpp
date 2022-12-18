// 221218_BOJ_22971

#include <iostream>

using namespace std;

int N, A[5001], B[5001];
const int DIV = 998244353;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    for (int i = 0; i < N; ++i)
    {
        B[i] = 1;
        for (int j = 0; j < i; ++j)
        {
            if (A[j] < A[i])
            {
                B[i] = (B[i] + B[j]) % DIV;
            }
        }
        cout << B[i] << " ";
    }

    return 0;
}
