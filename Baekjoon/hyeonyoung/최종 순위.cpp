// 230107_BOJ_3665

#include <iostream>
#include <cstring>
#include <queue>
#include <string>

using namespace std;

int TC, N, T[501], M;
bool adj[501][501];
int inorder[501];
string output;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> TC;
    while (TC-- > 0)
    {
        memset(adj, 0, sizeof(adj));
        memset(inorder, 0, sizeof(inorder));
        output = "";

        cin >> N;
        for (int i = 1; i <= N; ++i)
        {
            cin >> T[i];
        }
        for (int i = 1; i <= N; ++i)
        {
            for (int j = i + 1; j <= N; ++j)
            {
                adj[T[i]][T[j]] = 1;
            }
        }

        cin >> M;
        for (int i = 0; i < M; ++i)
        {
            int a, b;
            cin >> a >> b;
            if (adj[a][b])
            {
                adj[a][b] = 0;
                adj[b][a] = 1;
            }
            else
            {
                adj[a][b] = 1;
                adj[b][a] = 0;
            }
        }

        for (int i = 1; i <= N; ++i)
        {
            for (int j = 1; j <= N; ++j)
            {
                if (adj[i][j])
                {
                    inorder[j]++;
                }
            }
        }

        queue<int> q;
        for (int i = 1; i <= N; ++i)
        {
            if (inorder[i] == 0)
            {
                q.push(i);
            }
        }

        queue<int> answer;
        while (!q.empty())
        {
            if (q.size() > 1)
            {
                output = "?";
                break;
            }

            int x = q.front();
            q.pop();
            answer.push(x);

            for (int i = 1; i <= N; ++i)
            {
                if (adj[x][i] && --inorder[i] == 0)
                {
                    q.push(i);
                }
            }
        }
        if (answer.size() < N)
        {
            output = "IMPOSSIBLE";
        }

        if (output.length() == 0)
        {
            while (!answer.empty())
            {
                cout << answer.front() << " ";
                answer.pop();
            }
            cout << "\n";
        }
        else
        {
            cout << output << "\n";
        }
    }

    return 0;
}
