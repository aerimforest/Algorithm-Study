// 230108_BOJ_14503

#include <iostream>

using namespace std;

int N, M, board[51][51]; // 0: 빈 칸 1: 벽 2: 청소한 칸
int r, c, d;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    cin >> r >> c >> d;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> board[i][j];
        }
    }

    int answer = 0;
    while (1)
    {
        // 1. 현재 위치 청소
        if (board[r][c] == 0)
        {
            answer++;
            board[r][c] = 2;
        }

        // 2. 주변 탐색
        bool mov = false;
        // 2-1,2. 4방향 탐색
        for (int k = 0; k < 4; ++k)
        {
            d = (d + 3) % 4;
            int rr = r + dx[d], cc = c + dy[d];

            if (board[rr][cc] == 0)
            {
                mov = true;
                r = rr;
                c = cc;
                break;
            }
        }
        if (mov)
        {
            continue;
        }
        // 2-3. 한 칸 후진
        if (board[r - dx[d]][c - dy[d]] != 1)
        {
            r -= dx[d];
            c -= dy[d];
        }
        else
        {
            break;
        }
    }
    cout << answer;

    return 0;
}
