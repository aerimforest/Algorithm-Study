// 221231_BOJ_3273

#include <iostream>
#include <algorithm>

using namespace std;

int N, A[100001], X;
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
    cin >> X;

    int a = 0, b = N - 1;
    while (a < b)
    {
        if (A[a] + A[b] == X)
        {
            answer++;
            a++;
            b--;
        }
        else if (A[a] + A[b] < X)
        {
            a++;
        }
        else if (A[a] + A[b] > X)
        {
            b--;
        }
    }
    cout << answer;

    return 0;
}
