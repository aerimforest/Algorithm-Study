// 221009_BOJ_2234

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, castle[51][51], visit[51][51];
vector<int> room = {0};

int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> castle[i][j];
        }
    }

    for (int i = 0; i < M; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (visit[i][j] != 0)
            {
                continue;
            }

            queue<pair<int, int>> Q;
            visit[i][j] = room.size();
            Q.push({i, j});
            room.push_back(0);

            while (!Q.empty())
            {
                int x = Q.front().first, y = Q.front().second;
                Q.pop();

                room[visit[x][y]]++;

                for (int k = 0; k < 4; ++k)
                {
                    if (castle[x][y] & (1 << k))
                    {
                        continue;
                    }

                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= M || yy < 0 || yy >= N)
                    {
                        continue;
                    }

                    if (visit[xx][yy] == 0)
                    {
                        visit[xx][yy] = visit[x][y];
                        Q.push({xx, yy});
                    }
                }
            }
        }
    }

    int cnt = room.size() - 1;
    cout << cnt << "\n";

    int large = 0;
    for (int i = 1; i <= cnt; ++i)
    {
        large = max(large, room[i]);
    }
    cout << large << "\n";

    int sum = 0;
    for (int i = 0; i < M; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (i > 0)
            {
                int a = visit[i][j], b = visit[i - 1][j];
                if (a != b)
                    sum = max(sum, room[a] + room[b]);
            }
            if (j > 0)
            {
                int a = visit[i][j], b = visit[i][j - 1];
                if (a != b)
                    sum = max(sum, room[a] + room[b]);
            }
        }
    }
    cout << sum;

    return 0;
}
