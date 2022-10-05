// 221005_BOJ_19238

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N, M, F, board[21][21];
pair<int, int> S, P[401];
int visit[21][21];

int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};

pair<int, int> findP(pair<int, int> cur)
{
    pair<int, int> ret = {0, 0};

    memset(visit, 0, sizeof(visit));
    visit[0][0] = 987654321;
    queue<pair<int, int>> Q;

    visit[cur.first][cur.second] = 1;
    Q.push(cur);
    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        if (board[x][y] > 0)
        {
            if (visit[x][y] < visit[ret.first][ret.second])
            {
                ret = {x, y};
            }
            else if (visit[x][y] == visit[ret.first][ret.second])
            {
                if (x == ret.first)
                {
                    ret.second = min(y, ret.second);
                }
                else if (x < ret.first)
                {
                    ret = {x, y};
                }
            }
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx <= 0 || xx > N || yy <= 0 || yy > N)
            {
                continue;
            }

            if (board[xx][yy] != -1 && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }
    }

    return ret;
}

pair<int, int> findD(pair<int, int> cur, pair<int, int> D)
{
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> Q;

    visit[cur.first][cur.second] = 1;
    Q.push(cur);

    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        if (x == D.first && y == D.second)
        {
            return {x, y};
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx <= 0 || xx > N || yy <= 0 || yy > N)
            {
                continue;
            }

            if (board[xx][yy] != -1 && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }
    }

    return {0, 0};
}

int solve()
{
    int cnt = 0;
    while (1)
    {
        // 승객 찾기
        pair<int, int> p = findP(S);
        if (p.first == 0 && p.second == 0)
        {
            if (cnt == M)
            {
                break;
            }
            else
            {
                return -1;
            }
        }

        // 승객한테 이동
        if (F < visit[p.first][p.second] - 1)
        {
            return -1;
        }
        F -= visit[p.first][p.second] - 1;
        S = p;

        // 목적지로 이동
        pair<int, int> d = findD(S, P[board[p.first][p.second]]);
        if (d.first == 0 && d.second == 0)
        {
            return -1;
        }
        if (F < visit[d.first][d.second] - 1)
        {
            return -1;
        }
        F += visit[d.first][d.second] - 1;
        S = d;

        board[p.first][p.second] = 0;
        cnt++;
    }

    return F;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> F;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            cin >> board[i][j];
            board[i][j] *= -1;
        }
    }
    cin >> S.first >> S.second;
    for (int i = 1; i <= M; ++i)
    {
        int x, y;
        cin >> x >> y;
        cin >> P[i].first >> P[i].second;
        board[x][y] = i;
    }

    cout << solve();

    return 0;
}
