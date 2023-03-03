// 230114_BOJ_9466

#include <iostream>
#include <cstring>

using namespace std;

int T, N, S[100001];
int visit[100001], answer;

void dfs(int x)
{
    visit[x] = 1;
    if (visit[S[x]] == 0)
    {
        dfs(S[x]);
    }
    // cycle
    else if (visit[S[x]] == 1)
    {
        int tmp = S[x];
        answer--;
        while (tmp != x)
        {
            answer--;
            tmp = S[tmp];
        }
    }
    visit[x] = 2;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        memset(visit, 0, sizeof(visit));
        cin >> N;
        answer = N;
        for (int i = 1; i <= N; ++i)
        {
            cin >> S[i];
        }
        for (int i = 1; i <= N; ++i)
        {
            if (visit[i] == 0)
            {
                dfs(i);
            }
        }
        cout << answer << "\n";
    }

    return 0;
}
