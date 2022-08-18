// 220818 BOJ 17142

#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, M, lab[51][51];
int v_cnt = 0, w_cnt = 0, act = 0, visit[51][51];
pair<int, int> virus[11];
int ans = 987654321;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs()
{
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> Q;
    int ret = 1, cnt = 0;

    for (int i = 0; i < v_cnt; ++i)
    {
        cnt++;
        if (act & (1 << i))
        {
            visit[virus[i].first][virus[i].second] = 1;
            Q.push(virus[i]);
        }
    }

    while (!Q.empty() && cnt != N * N - w_cnt)
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];

            if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                continue;
            if (lab[xx][yy] == 1 || visit[xx][yy] != 0)
                continue;

            if (lab[xx][yy] != 2)
                cnt++;
            visit[xx][yy] = visit[x][y] + 1;
            ret = max(ret, visit[xx][yy]);
            Q.push({xx, yy});
        }
    }

    if (cnt == N * N - w_cnt)
        return ret - 1;
    else
        return 987654321;
}
void activate(int cnt, int idx)
{
    if (cnt == M)
    {
        ans = min(ans, bfs());
        return;
    }
    if (idx >= v_cnt)
    {
        return;
    }

    act |= (1 << idx);
    lab[virus[idx].first][virus[idx].second] = 3;
    activate(cnt + 1, idx + 1);
    act -= (1 << idx);
    lab[virus[idx].first][virus[idx].second] = 2;
    activate(cnt, idx + 1);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> lab[i][j];
            if (lab[i][j] == 2)
            {
                virus[v_cnt++] = {i, j};
            }
            else if (lab[i][j] == 1)
            {
                w_cnt++;
            }
        }
    }

    activate(0, 0);

    if (ans >= 987654321)
        ans = -1;
    cout << ans;

    return 0;
}
