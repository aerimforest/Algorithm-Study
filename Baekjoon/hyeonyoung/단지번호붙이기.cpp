// 230114_BOJ_2667

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int N;
char board[26][26];
bool visit[26][26];
vector<int> answer;

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (board[i][j] == '0' || visit[i][j])
            {
                continue;
            }

            queue<pair<int, int>> q;
            int cnt = 0;
            visit[i][j] = true;
            q.push({i, j});
            while (!q.empty())
            {
                cnt++;
                int x = q.front().first, y = q.front().second;
                q.pop();

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                    {
                        continue;
                    }

                    if (board[xx][yy] == '1' && !visit[xx][yy])
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
        cout << a << "\n";
    }

    return 0;
}
