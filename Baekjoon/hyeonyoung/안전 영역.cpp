// 220926_BOJ_2468

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N, H[101][101];
int visit[101][101], ans = 1;
queue<pair<int, int>> Q;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> H[i][j];
        }
    }

    for (int h = 1; h <= 100; ++h)
    {
        int cnt = 0;
        memset(visit, 0, sizeof(visit));
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if (H[i][j] > h && visit[i][j] == 0)
                {
                    visit[i][j] = ++cnt;
                    Q.push({i, j});
                    while (!Q.empty())
                    {
                        int x = Q.front().first, y = Q.front().second;
                        Q.pop();

                        for (int k = 0; k < 4; ++k)
                        {
                            int xx = x + dx[k], yy = y + dy[k];
                            if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                            {
                                continue;
                            }
                            if (H[xx][yy] > h && visit[xx][yy] == 0)
                            {
                                visit[xx][yy] = cnt;
                                Q.push({xx, yy});
                            }
                        }
                    }
                }
            }
        }
        ans = max(ans, cnt);
        if (cnt == 0)
        {
            break;
        }
    }

    cout << ans;

    return 0;
}
