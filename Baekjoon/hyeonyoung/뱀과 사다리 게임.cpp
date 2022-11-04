// 221104_BOJ_16928

#include <iostream>
#include <queue>

using namespace std;

int N, M, answer = 0;
int mov[101], visit[101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N + M; ++i)
    {
        int x, y;
        cin >> x >> y;
        mov[x] = y;
    }

    queue<int> q;
    visit[1] = 1;
    q.push(1);
    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (cur == 100)
        {
            answer = visit[cur] - 1;
            break;
        }

        for (int k = 1; k <= 6; ++k)
        {
            if (cur + k > 100)
            {
                continue;
            }

            // 사다리, 뱀 있을 때
            if (mov[cur + k] && visit[mov[cur + k]] == 0)
            {
                visit[mov[cur + k]] = visit[cur + k] = visit[cur] + 1;
                q.push(mov[cur + k]);
            }
            // 사다리, 뱀 없을 때
            else if (mov[cur + k] == 0 && visit[cur + k] == 0)
            {
                visit[cur + k] = visit[cur] + 1;
                q.push(cur + k);
            }
        }
    }

    cout << answer;

    return 0;
}
