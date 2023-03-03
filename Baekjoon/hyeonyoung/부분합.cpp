// 230115_BOJ_1806

#include <iostream>

using namespace std;

int N, S, A[100001], answer = 1000000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> S;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    int x = 0, y = 0, sum = A[0];
    while (x < N && y < N)
    {
        if (sum >= S)
        {
            answer = min(answer, y - x + 1);
            sum -= A[x++];
        }
        else
        {
            sum += A[++y];
        }
    }

    if (answer > N)
    {
        answer = 0;
    }
    cout << answer;

    return 0;
}
