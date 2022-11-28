// 221122_BOJ_1205

#include <iostream>

using namespace std;

int N, S, P, R[51];
int answer;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> S >> P;
    for (int i = 1; i <= N; ++i)
    {
        cin >> R[i];
    }
    answer = N + 1;

    // 랭킹 올라갈 수 없을 때
    if (N == P && R[N] >= S)
    {
        answer = -1;
    }
    else
    {
        for (int i = 1; i <= N; ++i)
        {
            if (R[i] <= S)
            {
                answer = i;
                break;
            }
        }
    }

    cout << answer;

    return 0;
}
