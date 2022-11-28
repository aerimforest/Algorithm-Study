// 221115_BOJ_2583

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int M, N, K;
bool grid[101][101], visit[101][101];
vector<int> answer;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N >> K;
    for (int k = 0; k < K; ++k)
    {
        int x, y, xx, yy;
        cin >> x >> y >> xx >> yy;
        for (int i = x; i < xx; ++i)
        {
            for (int j = y; j < yy; ++j)
            {
                grid[i][j] = true;
            }
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (visit[i][j] || grid[i][j])
            {
                continue;
            }

            int cnt = 0;
            queue<pair<int, int>> q;
            visit[i][j] = true;
            q.push({i, j});
            while (!q.empty())
            {
                int x = q.front().first, y = q.front().second;
                q.pop();

                cnt++;
                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= N || yy < 0 || yy >= M)
                    {
                        continue;
                    }

                    if (grid[xx][yy] == false && visit[xx][yy] == false)
                    {
                        visit[xx][yy] = true;
                        q.push({xx, yy});
                    }
                }
            }
            answer.push_back(cnt);
        }
    }

    sort(answer.begin(), answer.end());
    cout << answer.size() << "\n";
    for (int a : answer)
    {
        cout << a << " ";
    }

    return 0;
}
