// 221110_BOJ_2638

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, M, cheese[100][100], visit[100][100], cnt = 0;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> cheese[i][j];
            if (cheese[i][j])
            {
                cnt++;
            }
        }
    }

    int T;
    for (T = 0; cnt > 0; ++T)
    {
        memset(visit, 0, sizeof(visit));
        queue<pair<int, int>> q;
        visit[0][0] = 1;
        q.push({0, 0});
        while (!q.empty())
        {
            int x = q.front().first, y = q.front().second;
            q.pop();

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= M)
                {
                    continue;
                }

                if (cheese[xx][yy] == 0 && visit[xx][yy] == 0)
                {
                    visit[xx][yy] = 1;
                    q.push({xx, yy});
                }
            }
        }

        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                if (cheese[i][j] == 0)
                {
                    continue;
                }

                int around = 0;
                for (int k = 0; k < 4; ++k)
                {
                    if (visit[i + dx[k]][j + dy[k]] == 1)
                    {
                        around++;
                    }
                }
                if (around >= 2)
                {
                    cheese[i][j] = 0;
                    cnt--;
                }
            }
        }
    }
    cout << T;

    return 0;
}
