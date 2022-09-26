// 220926_BOJ_1107

#include <iostream>

using namespace std;

const int MAX = 1000000;
int N, M, visit[MAX + 1];
bool broken[10];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int x;
        cin >> x;
        broken[x] = true;
    }

    int ans = abs(N - 100);
    if (!broken[0])
    {
        ans = min(ans, N + 1);
    }

    for (int i = 1; i <= MAX; ++i)
    {
        int cnt = 0;
        int tmp = i;
        while (tmp > 0)
        {
            if (broken[tmp % 10])
            {
                cnt = MAX;
                break;
            }
            cnt++;
            tmp /= 10;
        }
        ans = min(ans, cnt + abs(N - i));
    }

    cout << ans;

    return 0;
}
