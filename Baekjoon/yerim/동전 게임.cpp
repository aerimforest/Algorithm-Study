// [9079] 동전 게임
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

bool visited[513];
int map[3][3];

int getBitMap()
{
    int idx = 0, num = 0;
    for(int i = 2; i >= 0; i--) {
        for(int j = 2; j >= 0; j--) {
            num += map[i][j] * (1 << idx);
            idx++;
        }
    }
    return num;
}

void getCharMap(int bitMap)
{
    for(int i = 2; i >= 0; i--) {
        for(int j = 2; j >= 0; j--) {
            map[i][j] = bitMap % 2;
            bitMap /= 2;
        }
    }
}

void flipRow(int i)
{
    for(int j = 0; j < 3; j++) {
        map[i][j] = (1 - map[i][j]);
    }
}

void flipColumn(int i) {
    for(int j = 0; j < 3; j++) {
        map[j][i] = (1 - map[j][i]);
    }
}

void flipDiagonal(int dir)
{
    for(int i = 0; i < 3; i++) {
        if(dir == 0) {
            map[i][i] = (1 - map[i][i]);
        }
        else {
            map[i][2 - i] = (1 - map[i][2 - i]);
        }
    }
}

void bfs()
{
    queue<pair<int, int>> q; // <map 상태, 뒤집은 횟수>
    int bitMap = getBitMap();
    q.push({bitMap, 0});
    visited[bitMap] = true;

    while(!q.empty()) {
        int curMap = q.front().first;
        int curFlip = q.front().second;
        q.pop();

        if(curMap == 0 || curMap == 511) {
            cout << curFlip << '\n';
            return;
        }

        int newMap;
        getCharMap(curMap);
        // 가로 
        for(int i = 0; i < 3; i++) {
            flipRow(i); // 한 줄 뒤집기
            newMap = getBitMap();
            if(visited[newMap] == false) {
                visited[newMap] = true;
                q.push({newMap, curFlip + 1});
            }
            flipRow(i); // 원상복구
        }
        // 세로
        for(int i = 0; i < 3; i++) {
            flipColumn(i);
            newMap = getBitMap(); // 한 줄 뒤집기
            if(visited[newMap] == false) {
                visited[newMap] = true;
                q.push({newMap, curFlip + 1});
            }
            flipColumn(i); // 원상복구
        }
        // 대각선
        for(int i = 0; i < 2; i++) { // 우하향, 우상향
            flipDiagonal(i);
            newMap = getBitMap();
            if(visited[newMap] == false) {
                visited[newMap] = true;
                q.push({newMap, curFlip + 1});
            }
            flipDiagonal(i); // 원상복구
        }
    }
    cout << "-1\n"; // 불가능
}

void input()
{
    int t;
    char state;
    cin >> t;
    while(t--) {
        memset(visited, false, sizeof(visited));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                cin >> state;
                map[i][j] = (state == 'H') ? 1 : 0;
            }
        }
        bfs();
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}