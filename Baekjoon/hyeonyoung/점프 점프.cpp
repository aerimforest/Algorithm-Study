// 221208_BOJ_11060

#include <iostream>
#include <queue>

using namespace std;

int N, A[1001], visit[1001], answer = -1;
queue<int> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    visit[0] = 1;
    q.push(0);
    while (!q.empty())
    {
        int x = q.front();
        q.pop();

        if (x == N - 1)
        {
            answer = visit[N - 1] - 1;
            break;
        }

        for (int k = 1; k <= A[x]; ++k)
        {
            if (visit[x + k] == 0)
            {
                visit[x + k] = visit[x] + 1;
                q.push(x + k);
            }
        }
    }
    cout << answer;

    return 0;
}
