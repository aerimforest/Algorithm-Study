// 221128_BOJ_16918

#include <iostream>
#include <algorithm>

using namespace std;

int T, N, M, A[20001], B[20001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> N >> M;
        for (int i = 0; i < N; ++i)
        {
            cin >> A[i];
        }
        sort(A, A + N);
        for (int j = 0; j < M; ++j)
        {
            cin >> B[j];
        }
        sort(B, B + M);

        int answer = 0;
        int x = 0, y = 0;
        for (x = 0; x < N; ++x)
        {
            while (y < M && A[x] > B[y])
            {
                y++;
            }
            answer += y;
        }
        cout << answer << "\n";
    }

    return 0;
}
