// [7569] 토마토
#include <iostream>
#include <queue>
using namespace std;

int N, M, H, day;
int map[101][101][101];
int dx[6] = {-1, 0, 1, 0, 0, 0}, dy[6] = {0, 1, 0, -1, 0, 0}, dz[6] = {0, 0, 0, 0, -1, 1};
struct Info {
    int h;
    int x;
    int y;
    int day;
};
queue<Info> ripedQ;

void input()
{
    cin >> M >> N >> H;
    for(int i = 0; i < H; i++) {
        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                cin >> map[i][j][k];
                if(map[i][j][k] == 1) {
                    ripedQ.push({i, j, k, 0});
                }
            }
        }
    }
}

void beginStorage()
{
    while(!ripedQ.empty()) {
        int z = ripedQ.front().h;
        int x = ripedQ.front().x;
        int y = ripedQ.front().y;
        day = ripedQ.front().day;
        ripedQ.pop();
        for(int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i]; 
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                continue;
            }
            if(map[nz][nx][ny] != 0) {
                continue;
            }
            ripedQ.push({nz, nx, ny, day + 1});
            map[nz][nx][ny] = 1; 
        }
    }
}

bool isAllRiped()
{
    for(int i = 0; i < H; i++) {
        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                if(map[i][j][k] == 0) {
                    return false;
                }
            }
        }
    }
    return true;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    beginStorage();
    if(isAllRiped()) cout << day << '\n';
    else cout << "-1\n";

    return 0;
}