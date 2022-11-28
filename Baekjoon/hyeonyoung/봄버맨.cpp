// 221128_BOJ_16918

#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int R, C, N;
char board[201][201];
bool visit[201][201];
vector<pair<int, int>> bomb[2];

const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C >> N;
    for (int i = 0; i < R; ++i)
    {
        cin >> board[i];
        for (int j = 0; j < C; ++j)
        {
            if (board[i][j] == '.')
            {
                visit[i][j] = 1;
            }
            else
            {
                bomb[0].push_back({i, j});
            }
        }
    }

    if ((N & 1) == 0)
    {
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                cout << 'O';
            }
            cout << "\n";
        }
    }
    else
    {
        N >>= 1;
        for (int i = 0; i < N; ++i)
        {
            memset(visit, 0, sizeof(visit));
            for (pair<int, int> b : bomb[i & 1])
            {
                int x = b.first, y = b.second;
                visit[x][y] = 1;
                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];
                    if (xx < 0 || xx >= R || yy < 0 || yy >= C)
                    {
                        continue;
                    }
                    visit[xx][yy] = 1;
                }
            }

            bomb[(i + 1) & 1] = {};
            for (int x = 0; x < R; ++x)
            {
                for (int y = 0; y < C; ++y)
                {
                    if (!visit[x][y])
                    {
                        bomb[(i + 1) & 1].push_back({x, y});
                    }
                }
            }
        }

        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                if (visit[i][j])
                {
                    cout << ".";
                }
                else
                {
                    cout << "O";
                }
            }
            cout << "\n";
        }
    }

    return 0;
}
