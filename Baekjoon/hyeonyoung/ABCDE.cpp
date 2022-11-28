// 221120_BOJ_13023

#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int> fr[2001];
bool visit[2001], answer = false;

void solve(int cur, int cnt)
{
    if (cnt >= 5)
    {
        answer = true;
        return;
    }
    if (answer)
    {
        return;
    }

    for (int next : fr[cur])
    {
        if (!visit[next])
        {
            visit[next] = true;
            solve(next, cnt + 1);
            visit[next] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int x, y;
        cin >> x >> y;
        fr[x].push_back(y);
        fr[y].push_back(x);
    }

    for (int i = 0; i < N && !answer; ++i)
    {
        visit[i] = true;
        solve(i, 1);
        visit[i] = false;
    }
    cout << answer;

    return 0;
}
