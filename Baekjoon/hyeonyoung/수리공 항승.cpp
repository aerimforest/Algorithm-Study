// 230108_BOJ_1449

#include <iostream>
#include <algorithm>

using namespace std;

int N, L, A[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }
    sort(A, A + N);

    int cur = A[0], answer = 0;
    for (int i = 1; i < N; ++i)
    {
        if (A[i] - cur >= L)
        {
            answer++;
            cur = A[i];
        }
    }
    cout << ++answer;

    return 0;
}
