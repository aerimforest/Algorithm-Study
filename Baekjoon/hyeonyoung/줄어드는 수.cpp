// 221127_BOJ_1174

#include <iostream>
#include <queue>

using namespace std;

int N;
long long answer = -1;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    queue<long long> q;
    int cnt = 0;
    for (long long i = 0; i < 10; ++i)
    {
        q.push(i);
    }

    while (!q.empty())
    {
        long long x = q.front();
        q.pop();

        if (++cnt == N)
        {
            answer = x;
            break;
        }

        for (int y = 0; y < x % 10; ++y)
        {
            q.push(10 * x + y);
        }
    }
    cout << answer;

    return 0;
}
