// [19236] 청소년 상어
// map {-1  = 상어 or 빈 칸, 1~16: 물고기}
#include <iostream>
using namespace std;

int result = 0, map[4][4];
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1}, dy[8] = {0, -1, -1, -1, 0, 1, 1, 1};

struct Fish {
    int x = 0;    
    int y = 0;   
    int dir = 0; 
    bool isAlive = true;  
};

void stimulation(int map[4][4], Fish fish[], int sharkX, int sharkY, int sum) {
    int tmpMap[4][4];
    Fish tmpFish[17];

    // init
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++)
            tmpMap[i][j] = map[i][j];
    }
    for (int i = 1; i <= 16; i++) {
        tmpFish[i] = fish[i];
    }

    // 상어가 물고기 먹음
    int fishNum = tmpMap[sharkX][sharkY];
    tmpMap[sharkX][sharkY] = -1;    

    int sharkDir = tmpFish[fishNum].dir;
    tmpFish[fishNum].isAlive = false; 

    sum += fishNum;
    result = max(result, sum);

    // 물고기 이동
    for (int i = 1; i <= 16; i++) {
        if (tmpFish[i].isAlive) {
            int x = tmpFish[i].x;
            int y = tmpFish[i].y;
            int dir = tmpFish[i].dir;
            int nx = x + (dx[dir % 8]);
            int ny = y + (dy[dir % 8]);

            while (nx < 0 || nx > 3 || ny < 0 || ny > 3 || (sharkX == nx && sharkY == ny)) {
                dir++;
                nx = x + (dx[dir % 8]);
                ny = y + (dy[dir % 8]);
            }

            // 물고기 swap
            if (tmpMap[nx][ny] != -1) {
                int swap_fish = tmpMap[nx][ny];
                tmpFish[i].x = nx;
                tmpFish[i].y = ny;
                tmpFish[i].dir = dir;
                tmpFish[swap_fish].x = x;
                tmpFish[swap_fish].y = y;

                tmpMap[nx][ny] = i;
                tmpMap[x][y] = swap_fish;
            }
            else { // 빈 칸
                tmpFish[i].x = nx;
                tmpFish[i].y = ny;
                tmpFish[i].dir = dir;
                tmpMap[nx][ny] = i;
                tmpMap[x][y] = -1;
            }
        }
    }
    // 상어 이동(최대 3칸)
    for (int i = 1; i < 4; i++) {
        int ndx = dx[sharkDir % 8] * i;
        int ndy = dy[sharkDir % 8] * i;
        int nx = sharkX + ndx;
        int ny = sharkY + ndy;

        if (nx < 0 || nx > 3 || ny < 0 || ny > 3) break;
        if (tmpMap[nx][ny] != -1) {
            stimulation(tmpMap, tmpFish, nx, ny, sum);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int num, dir;
    Fish fish[17];

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> num >> dir;
            dir--;
            map[i][j] = num;
            fish[num].x = i;
            fish[num].y = j;
            fish[num].dir = dir;
        }
    }
    stimulation(map, fish, 0, 0, 0);
    cout << result << '\n';
    return 0;
}