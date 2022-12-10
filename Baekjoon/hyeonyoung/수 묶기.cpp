// 221210_BOJ_1744

#include <iostream>
#include <algorithm>

using namespace std;

int N, A[51];
int answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }
    sort(A, A + N);

    // 0 이하
    int idx = 0;
    while (idx < N && A[idx] <= 0)
    {
        if (idx + 1 < N && A[idx + 1] <= 0)
        {
            answer += A[idx] * A[idx + 1];
            idx += 2;
        }
        else
        {
            answer += A[idx];
            idx++;
        }
    }
    // 양수
    idx = N - 1;
    while (idx >= 0 && A[idx] > 0)
    {
        if (idx - 1 >= 0 && A[idx - 1] > 1)
        {
            answer += A[idx - 1] * A[idx];
            idx -= 2;
        }
        else
        {
            answer += A[idx];
            idx--;
        }
    }
    cout << answer;

    return 0;
}
