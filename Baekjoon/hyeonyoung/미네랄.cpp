// 221225_BOJ_2933

#include <iostream>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

int R, C, N, H;
char cave[101][101];
bool visit[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void mov_cluster(int i, int j)
{
    vector<pair<int, int>> cluster;
    queue<pair<int, int>> q;
    memset(visit, 0, sizeof(visit));
    visit[i][j] = 1;
    q.push({i, j});
    while (!q.empty())
    {
        int x = q.front().first, y = q.front().second;
        q.pop();
        cluster.push_back({x, y});

        if (x == R - 1)
        {
            return;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= R || yy < 0 || yy >= C)
            {
                continue;
            }
            if (cave[xx][yy] == 'x' && visit[xx][yy] == 0)
            {
                visit[xx][yy] = 1;
                q.push({xx, yy});
            }
        }
    }

    for (pair<int, int> p : cluster)
    {
        cave[p.first][p.second] = '.';
    }

    for (int k = 1;; ++k)
    {
        for (pair<int, int> p : cluster)
        {
            if (p.first + k >= R || cave[p.first + k][p.second] == 'x')
            {
                k--;
                for (pair<int, int> pp : cluster)
                {
                    cave[pp.first + k][pp.second] = 'x';
                }
                return;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C;
    for (int i = 0; i < R; ++i)
    {
        cin >> cave[i];
    }
    cin >> N;
    for (int n = 0; n < N; ++n)
    {
        cin >> H;

        int x = R - H, y;
        // <---
        if (n & 1)
        {
            for (y = C - 1; y >= 0; --y)
            {
                if (cave[x][y] == 'x')
                {
                    break;
                }
            }
        }
        // -->
        else
        {
            for (y = 0; y < C; ++y)
            {
                if (cave[x][y] == 'x')
                {
                    break;
                }
            }
        }

        if (y == -1 || y == C)
        {
            continue;
        }

        cave[x][y] = '.';
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= R || yy < 0 || yy >= C)
            {
                continue;
            }
            if (cave[xx][yy] == 'x')
            {
                mov_cluster(xx, yy);
            }
        }
    }
    for (int i = 0; i < R; ++i)
    {
        for (int j = 0; j < C; ++j)
        {
            cout << cave[i][j];
        }
        cout << "\n";
    }

    return 0;
}
