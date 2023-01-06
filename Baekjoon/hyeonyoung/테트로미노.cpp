// 230106_BOJ_14500

#include <iostream>
#include <cstring>

using namespace std;

int N, M, board[501][501], answer = 0;

int dx[19][3] = {
    {0, 0, 0},
    {1, 2, 3},
    {0, 1, 1},
    {1, 2, 2},
    {1, 1, 1},

    {0, 1, 2},
    {-1, -1, -1},
    {0, -1, -2},
    {1, 1, 1},
    {0, 1, 2},

    {-1, -1, -1},
    {1, 1, 2},
    {0, 1, 1},
    {1, 1, 2},
    {0, 1, 1},

    {0, 0, 1},
    {-1, 0, 1},
    {0, 0, -1},
    {-1, 0, 1}};
int dy[19][3] = {
    {1, 2, 3},
    {0, 0, 0},
    {1, 0, 1},
    {0, 0, 1},
    {0, -1, -2},

    {1, 1, 1},
    {0, 1, 2},
    {1, 1, 1},
    {0, 1, 2},
    {-1, -1, -1},

    {0, -1, -2},
    {0, 1, 1},
    {-1, -1, -2},
    {-1, 0, -1},
    {1, 1, 2},

    {-1, 1, 0},
    {0, 1, 0},
    {-1, 1, 0},
    {0, -1, 0}};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            for (int k = 0; k < 19; ++k)
            {
                int cnt = board[i][j];
                for (int l = 0; l < 3; ++l)
                {
                    int x = i + dx[k][l], y = j + dy[k][l];
                    if (x < 0 || x >= N || y < 0 || y >= M)
                    {
                        cnt = 0;
                        break;
                    }
                    cnt += board[x][y];
                }
                answer = max(answer, cnt);
            }
        }
    }
    cout << answer;

    return 0;
}
