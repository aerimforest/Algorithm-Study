// [20056] 마법사 상어와 파이어볼
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Info{
    int x;
    int y;
    int mass;
    int s;
    int d;
};
vector<Info> map[51][51];
vector<Info> fireballs;
int N, M, K;
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};

void input()
{
    int x, y, mass, d, s;
    cin >> N >> M >> K;
    for(int i = 1; i <= M; i++){
        cin >> x >> y >> mass >> s >> d;
        fireballs.push_back({x, y, mass, s, d});
    }
}

bool checkDir(int x, int y) { 
    bool evenFlag = false, oddFlag = false;
    for(int i = 0; i < map[x][y].size(); i++){
        if(map[x][y][i].d % 2) oddFlag = true;
        else evenFlag = true;
    }
    if(evenFlag && !oddFlag) return true;
    else if(!evenFlag && oddFlag) return true;
    else return false;
}

void moveFireball() {
    // init
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            map[i][j].clear();
        }
    }

    for(int i = 0; i < fireballs.size(); i++){
        Info cur = fireballs[i];
        int cx = cur.x, cy = cur.y;
        int nx = cx + dx[cur.d]*cur.s;
        int ny = cy + dy[cur.d]*cur.s;
        while(nx < 1) nx += N; 
        while(ny < 1) ny += N;
        while(nx > N) nx -= N;
        while(ny > N) ny -= N;
        map[nx][ny].push_back({nx, ny, cur.mass, cur.s, cur.d});
    }
    return;
}

void devideFireball() {
    vector<Info> temp;

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            int massSum = 0, sSum = 0;
            if(map[i][j].size() == 0) continue;
            if(map[i][j].size() == 1) temp.push_back(map[i][j][0]); 
            else { 
                for(int k = 0; k < map[i][j].size(); k++) {
                    massSum += map[i][j][k].mass;
                    sSum += map[i][j][k].s;
                }

                int massAverage = massSum / 5;
                int sAverage = sSum / map[i][j].size();
                if(massAverage == 0) continue;    
                if(checkDir(i, j)) {
                    for(int k = 0; k <= 6; k +=2) {
                        temp.push_back({i, j, massAverage, sAverage, k});
                    }
                } else {
                    for(int k = 1; k <= 7; k +=2) {
                        temp.push_back({i, j, massAverage, sAverage, k});
                    }
                }
            }
        }
    }
    fireballs = temp;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int asAverage = 0;

    input();
    for(int i = 1; i <= K; i++){
        moveFireball();
        devideFireball();
    }

    for(int i = 0; i < fireballs.size(); i++) {
        asAverage += fireballs[i].mass;
    }
    cout << asAverage << '\n';
    return 0;
}