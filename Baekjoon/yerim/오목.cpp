// [2615] 오목
// 구현, 브루트포스
#include <iostream>
#include <vector>
using namespace std;

int board[20][20], dx[4] = {-1, 0, 1, 1}, dy[4] = {1, 1, 1, 0};
vector<pair<int, int>> blackSpace, whiteSpace;

void input()
{
    for(int i = 1; i <= 19; i++) {
        for(int j = 1; j <= 19; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1) blackSpace.push_back(make_pair(i, j));
            else if(board[i][j] == 2) whiteSpace.push_back(make_pair(i, j));
        }
    }
}

bool isWin(int x, int y, int num)
{
    bool flag;
    int sx, sy, nx, ny, ex, ey;
    for(int i = 0; i < 4; i++) {
        flag = true;
        sx = x - dx[i]; sy = y - dy[i];
        nx = x; ny = y;
        if(board[sx][sy] == board[x][y]) {
            flag = false;
            continue;
        }
        for(int j = 0; j < 4; j++) {
            nx += dx[i]; ny += dy[i];
            if(board[nx][ny] != board[x][y] || nx < 1 || nx > 19 || ny < 1 || ny > 19) {
                flag = false;
                break;
            }
        }
        if(flag == true) {
            ex = nx + dx[i]; ey = ny + dy[i];
            if(board[ex][ey] != board[x][y]) {
                return true;
            }
        }
    }
    return false;
}

void getWinner()
{
    for(int i = 0; i < blackSpace.size(); i++) {
        int x = blackSpace[i].first;
        int y = blackSpace[i].second;

        if(isWin(x, y, 1)) {
            cout << "1" << '\n';
            cout << x << " " << y << '\n';
            return;
        }
    }
    for(int i = 0; i < whiteSpace.size(); i++) {
        int x = whiteSpace[i].first;
        int y = whiteSpace[i].second;

        if(isWin(x, y, 2)) {
            cout << "2" << '\n';
            cout << x << " " << y << '\n';
            return;
        }
    }  
    cout << "0" << '\n';
}

int main(void)
{
    input();
    getWinner();
}