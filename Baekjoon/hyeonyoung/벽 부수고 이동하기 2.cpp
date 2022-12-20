// 221220_BOJ_14442

#include <iostream>
#include <queue>

using namespace std;

int N, M, K;
char board[1001][1001];
int visit[1001][1001][11], answer = -1;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

struct state
{
    int x, y, z;
};
queue<state> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }

    visit[0][0][0] = 1;
    q.push({0, 0, 0});
    while (!q.empty())
    {
        int x = q.front().x, y = q.front().y, z = q.front().z;
        q.pop();

        if (x == N - 1 && y == M - 1)
        {
            answer = visit[x][y][z];
            break;
        }

        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx < 0 || xx >= N || yy < 0 || yy >= M)
            {
                continue;
            }

            if (board[xx][yy] == '0' && visit[xx][yy][z] == 0)
            {
                visit[xx][yy][z] = visit[x][y][z] + 1;
                q.push({xx, yy, z});
            }
            else if (board[xx][yy] == '1' && z < K && visit[xx][yy][z + 1] == 0)
            {
                visit[xx][yy][z + 1] = visit[x][y][z] + 1;
                q.push({xx, yy, z + 1});
            }
        }
    }
    cout << answer;

    return 0;
}
