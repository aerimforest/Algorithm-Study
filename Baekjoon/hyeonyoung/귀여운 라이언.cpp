// 221206_BOJ_15565

#include <iostream>

using namespace std;

int N, K, doll[1000001];
int answer = 10000000;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> doll[i];
    }

    int x = 0, y = 0, cnt = doll[0] == 1 ? 1 : 0;
    while (x < N)
    {
        if (cnt >= K)
        {
            answer = min(answer, y - x + 1);
            cnt -= doll[x++] == 1 ? 1 : 0;
        }
        else if (y + 1 < N)
        {
            cnt += doll[++y] == 1 ? 1 : 0;
        }
        else
        {
            break;
        }
    }
    if (answer == 10000000)
    {
        answer = -1;
    }
    cout << answer;

    return 0;
}
