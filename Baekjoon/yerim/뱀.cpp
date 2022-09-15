// [3190] 뱀
// 구현, 시뮬레이션, 덱
#include <iostream>
#include <deque>
using namespace std;

int n, k, l, moveDir = 1, map[101][101];
deque<pair<int, int>> snake;
deque<pair<int, char>> moveInfo;

void input()
{
    char dir;
    int x, y, second;
    cin >> n >> k;
    for(int i = 0; i < k; i++) {
        cin >> x >> y;
        map[x][y] = 1;
    }
    cin >> l;
    for(int i = 0; i < l; i++) {
        cin >> second >> dir;
        moveInfo.push_back(make_pair(second, dir));
    }
}

void changeDir(char dir)
{
    if(dir == 'L') {
        moveDir--;
        if(moveDir < 0) {
            moveDir = 3;
        }
    }
    else {
        moveDir++;
        if(moveDir > 3) {
            moveDir = 0;
        }
    }
}

int startMove()
{
    int nx = 1, ny = 1, length = 1;
    int seconds = 0, changeDirSecond = moveInfo.front().first;
    snake.push_back(make_pair(1, 1));

    while(true) {
        seconds++;

        if(moveDir == 0) nx--;
        else if(moveDir == 1) ny++;
        else if(moveDir == 2) nx++;
        else ny--;
    
        for(int i = 0; i < snake.size() - 1; i++) {
            if(nx == snake[i].first && ny == snake[i].second) {
                return seconds;
            }
        }

        if(1 <= nx && nx <= n && 1 <= ny && ny <= n) {
            snake.push_back(make_pair(nx, ny));
            if(map[nx][ny] == 1) {
                map[nx][ny] = 0;
                length++;
            }
            else {
                snake.pop_front();
            }
        }
        else {
            return seconds;
        }
        
        if(seconds == changeDirSecond) {
            changeDir(moveInfo.front().second);
            moveInfo.pop_front();
            changeDirSecond = moveInfo.front().first;
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    input();
    cout << startMove() << '\n';
    return 0;
}