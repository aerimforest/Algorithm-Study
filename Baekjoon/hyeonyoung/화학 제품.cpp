// 221128_BOJ_8901

#include <iostream>

using namespace std;

int T, A[3], AA[3];
int answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        for (int i = 0; i < 3; ++i)
        {
            cin >> A[i];
        }
        for (int i = 0; i < 3; ++i)
        {
            cin >> AA[i];
        }

        answer = 0;

        for (int ab = min(A[0], A[1]); ab >= 0; --ab)
        {
            for (int bc = min(A[1] - ab, A[2]); bc >= 0; --bc)
            {
                int ca = min(A[0] - ab, A[2] - bc);

                answer = max(answer, AA[0] * ab + AA[1] * bc + AA[2] * ca);
            }
        }

        cout << answer << "\n";
    }

    return 0;
}
