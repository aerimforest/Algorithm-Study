// [16918] 봄버맨
#include <cstring>
#include <iostream>
using namespace std;

char board[200][200], nextBoard[200][200];
int R, C, N;
int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

bool isValidIndex(int y, int x) 
{ 
    return y >= 0 && y < R && x >= 0 && x < C; 
}

void input() 
{
    cin >> R >> C >> N;
    getchar();
    memset(nextBoard, '.', sizeof(nextBoard));
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            board[i][j] = getchar();
        }
        getchar();
    }
}

void solve() 
{
    if (N % 2 == 0) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cout << "O";
            }
            cout << endl;
        }
        return;
    }

    for (int n = 1; n < N; n += 2) {
        memset(nextBoard, 'O', sizeof(nextBoard));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O') {
                    nextBoard[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        if (isValidIndex(i + dir[d][0], j + dir[d][1])) {
                            nextBoard[i + dir[d][0]][j + dir[d][1]] = '.';
                        }
                    }
                }
            }
        }
        memcpy(board, nextBoard, sizeof(nextBoard));
    }

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cout << board[i][j];
        }
        cout << '\n';
    }
}

int main() 
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  input();
  solve();

  return 0;
}