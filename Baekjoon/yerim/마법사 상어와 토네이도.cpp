// [20057] 마법사 상어와 토네이도
#include <iostream>
using namespace std;

int n, ans = 0, map[500][500];
int dx[4] = {0, 1, 0, -1}, dy[4] = {-1, 0, 1, 0};
int alphaX[4] = {0, 1, 0, -1}, alphaY[4] = {-1, 0, 1, 0};
int posOneX[4][2] = {{-1, 1}, {-1, -1}, {-1, 1}, {1, 1}}, posOneY[4][2] = {{1, 1}, {-1, 1}, {-1, -1}, {-1, 1}};
int posTwoX[4][2] = {{-2, 2}, {0, 0}, {-2, 2}, {0, 0}}, posTwoY[4][2] = {{0, 0}, {-2, 2}, {0, 0}, {-2, 2}};
int posFiveX[4] = {0, 2, 0, -2}, posFiveY[4] = {-2, 0, 2, 0};
int posSevenX[4][2] = {{-1, 1}, {0, 0}, {-1, 1}, {0, 0}}, posSevenY[4][2] = {{0, 0}, {-1, 1}, {0, 0}, {-1, 1}};
int posTenX[4][2] = {{-1, 1}, {1, 1}, {-1, 1}, {-1, -1}}, posTenY[4][2] = {{-1, -1}, {-1, 1}, {1, 1}, {-1, 1}};

void input()
{
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            cin >> map[i][j];
        }
    }
}

void flutterSand(int r, int c, int dir)
{
    int yx = r + dx[dir], yy = c + dy[dir];
    int initSand = map[yx][yy], outSand = 0;
    int leftSand = initSand;
   
    if(map[yx][yy] == 0) return;
    map[yx][yy] = 0;
    
    for(int i = 0; i < 2; i++) {
        int x = yx + posOneX[dir][i];
        int y = yy + posOneY[dir][i];
        if(x < 1 || x > n || y < 1 || y > n) {
            outSand += (int)(initSand*0.01);
        }
        else {
            map[x][y] += (int)(initSand*0.01);
        }
        leftSand -= (int)(initSand*0.01);
    }
    
    for(int i = 0; i < 2; i++) {
        int x = yx + posTwoX[dir][i];
        int y = yy + posTwoY[dir][i];
        if(x < 1 || x > n || y < 1 || y > n) {
            outSand += (int)(initSand*0.02);
        }
        else {
            map[x][y] += (int)(initSand*0.02);
        }
        leftSand -= (int)(initSand*0.02);
    }
    
    int x = yx + posFiveX[dir];
    int y = yy + posFiveY[dir];
    if(x < 1 || x > n || y < 1 || y > n) {
        outSand += (int)(initSand*0.05);
    }
    else {
        map[x][y] += (int)(initSand*0.05);
    }
    leftSand -= (int)(initSand*0.05);

    for(int i = 0; i < 2; i++) {
        int x = yx + posSevenX[dir][i];
        int y = yy + posSevenY[dir][i];
        if(x < 1 || x > n || y < 1 || y > n) {
            outSand += (int)(initSand*0.07);
        }
        else {
            map[x][y] += (int)(initSand*0.07);
        }
        leftSand -= (int)(initSand*0.07);
    }
    
    for(int i = 0; i < 2; i++) {
        int x = yx + posTenX[dir][i];
        int y = yy + posTenY[dir][i];
        if(x < 1 || x > n || y < 1 || y > n) {
            outSand += (int)(initSand*0.1);
        }
        else {
            map[x][y] += (int)(initSand*0.1);
        }
        leftSand -= (int)(initSand*0.1);
    }
    
    x = yx + alphaX[dir];
    y = yy + alphaY[dir];
    if(x < 1 || x > n || y < 1 || y > n) {
        outSand += leftSand;
    }
    else {
        map[x][y] += leftSand;
    }

    ans += outSand;
}

int changeDir(int dir)
{
    if(0 <= dir && dir <= 2) {
        return dir + 1;
    }
    else {
        return 0;
    }
}

void setTornadoDir()
{
    int dir = 0; // 서쪽부터 이동 시작
    int x = (n+1)/2, y = (n+1)/2;

    flutterSand(x, y, dir);
    for(int i = 1; i < n; i++) {
        for(int j  = 0; j < 2; j++) {
            for(int k = 0; k < i; k++) {
                x += dx[dir];
                y += dy[dir];
                if(k == i-1) {
                    dir = changeDir(dir);
                }
                flutterSand(x, y, dir);
            }
        }
    }

    // 제일 윗줄
    for(int i = n-1; i >= 1; i--) {
        flutterSand(1, i, 0);
    }
}

int main(void)
{
    input();
    setTornadoDir();
    cout << ans << '\n';
}