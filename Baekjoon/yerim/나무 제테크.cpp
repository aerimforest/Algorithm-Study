// [16235] 나무 제테크
#include <iostream>
#include <deque>
using namespace std;

int N, M, K, a[11][11], nutrients[11][11];
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1}, dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
deque<int> map[11][11];

void input()
{
    int x, y, age;
    cin >> N >> M >> K;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            cin >> a[i][j];
            nutrients[i][j] = 5; // 가장 처음에 양분은 모든 칸에 5만큼 들어있음
        }
    }
    for(int i = 0; i < M; i++) {
        cin >> x >> y >> age;
        map[x][y].push_back(age);
    }
}

void springToSummer()
{
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            for(int k = 0; k < map[i][j].size(); k++) {
                // 양분이 충분한 경우
                if(nutrients[i][j] >= map[i][j][k]) {
                    nutrients[i][j] -= map[i][j][k];
                    map[i][j][k]++; // 나이 증가
                }
                // 양분이 부족한 경우 -> 현재 나무 ~ 남은 나무 전부 kill & 죽은 나무 -> 양분
                else {
                    int tmpNutrients = 0;
                    for(int l = k; l < map[i][j].size(); l++) {
                        tmpNutrients += (map[i][j][l] / 2);
                    }
                    nutrients[i][j] += (int)tmpNutrients;
                    map[i][j].erase(map[i][j].begin() + k, map[i][j].end());
                    break;
                }
            }
        }
    }
}

void startBreeding(int x, int y)
{
    for(int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
        map[nx][ny].push_front(1); // 새로 추가되는 나무의 나이는 기존 나무보다 항상 작기에 젤 앞에 삽입
    }
}

void autumn()
{
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            for(int k = 0; k < map[i][j].size(); k++) {
                if(map[i][j][k] % 5 == 0) {
                    startBreeding(i, j);
                }
            }
        }
    }
}

void winter()
{
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            nutrients[i][j] += a[i][j];
        }
    }
}

void solve()
{
    int year = 0;
    while(year < K) {
        year++;
        springToSummer();
        autumn();
        winter();
    }
}

int output()
{
    int ans = 0;
    for(int i = 1; i <= N ; i++) {
        for(int j = 1; j <= N; j++) {
            ans += map[i][j].size();
        }
    }
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);  
    cin.tie(NULL);

    input();
    solve();
    cout << output() << '\n';

    return 0;
}