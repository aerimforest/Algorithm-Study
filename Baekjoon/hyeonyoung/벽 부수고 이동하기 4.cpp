// 221223_BOJ_16946

#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

int N, M;
char board[1001][1001];
int visit[1001][1001];
vector<int> count = {0};

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (board[i][j] == '1' || visit[i][j] != 0)
            {
                continue;
            }

            queue<pair<int, int>> q;
            int cnt = 0;
            visit[i][j] = count.size();
            q.push({i, j});
            while (!q.empty())
            {
                int x = q.front().first, y = q.front().second;
                cnt++;
                q.pop();

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= N || yy < 0 || yy >= M)
                    {
                        continue;
                    }

                    if (board[xx][yy] == '0' && visit[xx][yy] == 0)
                    {
                        visit[xx][yy] = visit[x][y];
                        q.push({xx, yy});
                    }
                }
            }
            count.push_back(cnt);
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (board[i][j] == '0')
            {
                cout << '0';
            }
            else
            {
                int cnt = 1;
                set<int> mov;
                for (int k = 0; k < 4; ++k)
                {
                    int x = i + dx[k], y = j + dy[k];
                    if (x < 0 || x >= N || y < 0 || y >= M)
                    {
                        continue;
                    }
                    if (mov.find(visit[x][y]) == mov.end())
                    {
                        mov.insert(visit[x][y]);
                        cnt += count[visit[x][y]];
                    }
                }
                cout << cnt % 10;
            }
        }
        cout << "\n";
    }

    return 0;
}
