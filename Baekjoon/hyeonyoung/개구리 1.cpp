// 221129_BOJ_15566

#include <iostream>

using namespace std;

int N, M;
int conversation[16][5], lotus[16][2], logs[16][16];

int answer[16];
bool finish = false;

void solve(int frog)
{
    if (finish)
    {
        return;
    }
    if (frog > N)
    {
        finish = true;
        cout << "YES\n";
        for (int i = 1; i <= N; ++i)
        {
            cout << answer[i] << " ";
        }
        return;
    }

    if (answer[lotus[frog][0]] == 0)
    {
        int x = lotus[frog][0];
        bool push = true;
        for (int y = 1; y <= N; ++y)
        {
            if (logs[x][y] == 0 || answer[y] == 0)
            {
                continue;
            }

            int T = logs[x][y];
            if (conversation[frog][T] != conversation[answer[y]][T])
            {
                push = false;
            }
        }
        if (push)
        {
            answer[x] = frog;
            solve(frog + 1);
            answer[x] = 0;
        }
    }
    if (lotus[frog][0] != lotus[frog][1] && answer[lotus[frog][1]] == 0)
    {
        int x = lotus[frog][1];
        bool push = true;
        for (int y = 1; y <= N; ++y)
        {
            if (logs[x][y] != 0 && conversation[x][logs[x][y]] != conversation[y][logs[x][y]])
            {
                push = false;
            }
        }
        if (push)
        {
            answer[x] = frog;
            solve(frog + 1);
            answer[x] = 0;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= 4; ++j)
        {
            cin >> conversation[i][j]; // i번개구리의 j주제 흥미도
        }
    }
    for (int i = 1; i <= N; ++i)
    {
        cin >> lotus[i][0] >> lotus[i][1]; // ㅑ번개구리의 선호하는 연꽃
    }
    for (int i = 1; i <= M; ++i)
    {
        int A, B, T;
        cin >> A >> B >> T;
        logs[A][B] = logs[B][A] = T; // A, B 연꽃을 연결하는 통나무의 주제
    }

    solve(1);
    if (!finish)
    {
        cout << "NO\n";
    }

    return 0;
}
