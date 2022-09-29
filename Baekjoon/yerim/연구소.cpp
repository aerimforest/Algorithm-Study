// [14502] 연구소
#include <iostream>
#include <queue>
using namespace std;

int n, m, ans = 0; 
int map[9][9], tmpMap[9][9], afterVirus[9][9];
int dx[4] = { -1, 0, 1, 0 }, dy[4] = { 0, 1, 0, -1 };

void copyMap(int a[9][9], int b[9][9])
{
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            b[i][j] = a[i][j];
        }
    }
}

void findSafetyArea()
{
    int cnt = 0;
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            if(afterVirus[i][j] == 0) { 
                cnt++;
            }
        }
    }
    ans = (ans > cnt ? ans : cnt); 
}

void spreadVirus()
{
    copyMap(tmpMap, afterVirus); 

    // 바이러스의 위치 저장
    queue<pair<int, int>> virus;
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            if(afterVirus[i][j] == 2) {
                virus.push(make_pair(i, j));
            }
        }
    }

    while(!virus.empty()) {
        int x = virus.front().first;
        int y = virus.front().second;
        virus.pop();

        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < m) { 
                if(afterVirus[nx][ny] == 0) {
                    afterVirus[nx][ny] = 2;
                    virus.push(make_pair(nx, ny)); 
                }
            }
        }
    }

    findSafetyArea(); 
}

void makeWall(int cnt)
{
    if(cnt == 3) {
        spreadVirus(); 
        return;
    }

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            if(tmpMap[i][j] == 0) { 
                tmpMap[i][j] = 1;
                makeWall(cnt+1);
                tmpMap[i][j] = 0; 
            }
        }
    }
}

int main(void)
{
    cin >> n >> m;
    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            cin >> map[i][j];
        }
    }

    for(int i = 0 ; i < n ; i++) {
        for(int j = 0 ; j < m ; j++) {
            if(map[i][j] == 0) {
                copyMap(map, tmpMap);
                tmpMap[i][j] = 1; 
                makeWall(1);
                tmpMap[i][j] = 0; 
            }
        }
    }

    cout << ans << '\n';
    return 0;
}