// [20058] 마법사 상어와 파이어스톰
#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

bool isMelt[65][65];
int n, q, length, gap;
int map[65][65], level[1001], tmpMap[65][65], visited[65][65];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, -1, 0, 1};

void input()
{
    cin >> n >> q;
    length = (1<<n);
    for(int i = 1; i <= length; i++) {
        for(int j = 1; j <= length; j++) {
            cin >> map[i][j];
        }
    }    
    for(int i = 0; i < q; i++) {
        cin >> level[i];
    }
}

void rotateMap(int x, int y, int gap)
{
    for(int i = 1; i <= gap; i++) {
        for(int j = 1; j <= gap; j++) {
            tmpMap[i][j] = map[x+gap-j][y+i-1];
        }
    }
    
    for(int i = 0; i < gap; i++) {
        for(int j = 0; j < gap; j++) {
            map[x+i][y+j] = tmpMap[i+1][j+1];
        }
    }
}

void devideMap(int level)
{
    gap = (1<<level);
    for(int i = 1; i <= length; i+=gap) {
        for(int j = 1; j <= length; j+=gap) {
            rotateMap(i, j, gap);
        }
    }
}

void decreaseIce()
{
    memcpy(tmpMap, map, sizeof(tmpMap));
    for(int i = 1; i <= length; i++) {
        for(int j = 1; j <= length; j++) {
            int iceBlocks = 0;
            for(int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx < 1 || nx > length || ny < 1 || ny > length) {
                    continue;
                }
                if(map[nx][ny] > 0) {
                    iceBlocks++;
                }
            }
            if(iceBlocks < 3 && map[i][j] > 0) {
                tmpMap[i][j]--;
            }
        }
    }
    memcpy(map, tmpMap, sizeof(map));
}

int getMaxRemainIce(int x, int y)
{
    int iceBlocks = 1;
    queue<pair<int, int> > q;
    q.push(make_pair(x, y));
    visited[x][y] = true;

    while(!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx < 1 || nx > length || ny < 1 || ny > length) {
                continue;
            }
            if(map[nx][ny] > 0 && visited[nx][ny] == false) {
                iceBlocks++;
                visited[nx][ny] = true;
                q.push(make_pair(nx, ny));
            }
        }
    }

    return iceBlocks;
}

void output()
{
    int ans = 0, maxIceBlocks = 0;
    for(int i = 1; i <= length; i++) {
        for(int j = 1; j <= length; j++) {
            ans += map[i][j];
        }
    }
    cout << ans << '\n';

    for(int i = 1; i <= length; i++) {
        for(int j = 1; j <= length; j++) {
            if(map[i][j] > 0) {
                int iceBlocks = getMaxRemainIce(i, j);
                if(iceBlocks > maxIceBlocks) {
                    maxIceBlocks = iceBlocks;
                }
            }
        }
    }
    cout << maxIceBlocks << '\n';
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    for(int i = 0; i < q; i++) {
        devideMap(level[i]);
        decreaseIce();
    }
    output();
}