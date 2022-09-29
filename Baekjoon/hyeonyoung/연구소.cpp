// 220929_BOJ_14502

#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int N, M, lab[9][9], safe, visit[9][9];
int ans = 0;
vector<pair<int, int>> virus;
queue<pair<int, int>> Q;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void wall(int idx, int n)
{
    if (n == 3)
    {
        Q = {};
        memset(visit, 0, sizeof(visit));
        int cnt = safe;

        for (pair<int, int> v : virus)
        {
            visit[v.first][v.second] = 1;
            Q.push(v);
        }

        while (!Q.empty())
        {
            int x = Q.front().first, y = Q.front().second;
            Q.pop();
            cnt--;

            for (int k = 0; k < 4; ++k)
            {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= M)
                {
                    continue;
                }
                if (lab[xx][yy] == 0 && visit[xx][yy] == 0)
                {
                    visit[xx][yy] = 1;
                    Q.push({xx, yy});
                }
            }
        }

        ans = max(ans, cnt);

        return;
    }
    if (idx >= N * M)
    {
        return;
    }

    if (lab[idx / M][idx % M] == 0)
    {
        lab[idx / M][idx % M] = 1;
        safe--;
        wall(idx + 1, n + 1);
        safe++;
        lab[idx / M][idx % M] = 0;
    }
    wall(idx + 1, n);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> lab[i][j];

            if (lab[i][j] == 0)
            {
                safe++;
            }
            if (lab[i][j] == 2)
            {
                safe++;
                virus.push_back({i, j});
            }
        }
    }

    wall(0, 0);

    cout << ans;

    return 0;
}
