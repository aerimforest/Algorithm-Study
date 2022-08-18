#include <string>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int choose0(vector<vector<int>> &board, int r, int c, int cnt, int move);
int choose1(vector<vector<int>> &board, int r, int c, int cnt, int move, int card);

int choose0(vector<vector<int>> &board, int r, int c, int cnt, int move)
{
    // 카드 남아있는지 확인
    if (cnt == 0)
    {
        return move;
    }

    // BFS
    int visit[4][4], ret = 987654321;
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> Q;

    visit[r][c] = 1;
    Q.push({r, c});
    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        // Enter
        if (board[x][y] != 0)
        {
            int memo = board[x][y];
            board[x][y] = 0;
            ret = min(ret, choose1(board, x, y, cnt - 1, move + visit[x][y], memo));
            board[x][y] = memo;
        }

        // Ctrl + D
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            while (xx >= 0 && xx < 4 && yy >= 0 && yy < 4)
            {
                if (board[xx][yy] == 0)
                {
                    xx += dx[k];
                    yy += dy[k];
                }
                else
                {
                    break;
                }
            }
            if (xx < 0 || xx >= 4 || yy < 0 || yy >= 4)
            {
                xx -= dx[k];
                yy -= dy[k];
            }
            if (visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }

        // D
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx >= 0 && xx < 4 && yy >= 0 && yy < 4 && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }
    }

    return ret;
}
int choose1(vector<vector<int>> &board, int r, int c, int cnt, int move, int card)
{
    // BFS로 card 찾기
    int visit[4][4];
    memset(visit, 0, sizeof(visit));
    queue<pair<int, int>> Q;

    visit[r][c] = 1;
    Q.push({r, c});
    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();

        // Enter
        if (board[x][y] == card)
        {
            int memo = board[x][y];
            board[x][y] = 0;
            int ret = choose0(board, x, y, cnt - 1, move + visit[x][y]);
            board[x][y] = memo;

            return ret;
        }

        // Ctrl + D
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            while (xx >= 0 && xx < 4 && yy >= 0 && yy < 4)
            {
                if (board[xx][yy] == 0)
                {
                    xx += dx[k];
                    yy += dy[k];
                }
                else
                {
                    break;
                }
            }
            if (xx < 0 || xx >= 4 || yy < 0 || yy >= 4)
            {
                xx -= dx[k];
                yy -= dy[k];
            }
            if (visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }

        // D
        for (int k = 0; k < 4; ++k)
        {
            int xx = x + dx[k], yy = y + dy[k];
            if (xx >= 0 && xx < 4 && yy >= 0 && yy < 4 && visit[xx][yy] == 0)
            {
                visit[xx][yy] = visit[x][y] + 1;
                Q.push({xx, yy});
            }
        }
    }
    return 0;
}

int solution(vector<vector<int>> board, int r, int c)
{
    int answer = 0;

    int cnt = 0;
    for (int i = 0; i < 4; ++i)
    {
        for (int j = 0; j < 4; ++j)
        {
            if (board[i][j] > 0)
            {
                cnt++;
            }
        }
    }

    answer = choose0(board, r, c, cnt, 0);

    return answer;
}
