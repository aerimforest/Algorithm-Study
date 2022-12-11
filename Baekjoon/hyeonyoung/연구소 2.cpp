// 221211_BOJ_17141

#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int N, M, lab[51][51], visit[51][51], blank = 0;
vector<pair<int, int>> virus;
int answer = 0x7fffffff;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs()
{
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> q;
    for (pair<int, int> p : virus)
    {
        if (lab[p.first][p.second] == 3)
        {
            visit[p.first][p.second] = 1;
            q.push(p);
        }
    }

    int cnt = 0, ret = 0;
    while (!q.empty())
    {
        int x = q.front().first, y = q.front().second;
        q.pop();
        cnt++;
        ret = visit[x][y];

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= N)
            {
                continue;
            }
            if (lab[xx][yy] == 0 && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                q.push({xx, yy});
            }
        }
    }
    if (cnt == blank)
    {
        return ret - 1;
    }
    else
    {
        return answer;
    }
}

void solve(int idx, int cnt)
{
    if (cnt == M)
    {
        answer = min(answer, bfs());
        return;
    }
    if (idx == virus.size())
    {
        return;
    }

    lab[virus[idx].first][virus[idx].second] = 3;
    solve(idx + 1, cnt + 1);
    lab[virus[idx].first][virus[idx].second] = 0;
    solve(idx + 1, cnt);
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
                virus.push_back({i, j});
                lab[i][j] = 0;
                blank++;
            }
            else if (lab[i][j] == 0)
            {
                blank++;
            }
        }
    }

    solve(0, 0);
    if (answer == 0x7fffffff)
    {
        answer = -1;
    }
    cout << answer;

    return 0;
}
