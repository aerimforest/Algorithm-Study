// [18111] 마인크래프트
// 구현, 브루트포스
#include <iostream>
#define INF 1e9
using namespace std;

int n, m, b, map[501][501];
int minHeight = 257, maxHeight = -1;

void input()
{
    cin >> n >> m >> b;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> map[i][j];
            if(map[i][j] < minHeight) minHeight = map[i][j];
            if(map[i][j] > maxHeight) maxHeight = map[i][j];
        }
    }
}

int getCost(int height)
{
    /** 기준 높이보다 높이가 작은 칸을 계속 만날 경우 버킷이 음수가 될 수 있음
     -> 기준 높이보다 높이가 높은 칸부터 탐색하면서 버킷을 채운 뒤에 낮은 칸 탐색해야 함 **/
    int cut = 0, add = 0, tmpBucket = b;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(map[i][j] > height) {
                cut += (map[i][j] - height);    
                tmpBucket += (map[i][j] - height);
            }
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(map[i][j] < height) {
                add += (height - map[i][j]);
                tmpBucket -= (height - map[i][j]);
                if(tmpBucket < 0) return INF;
            }
        }
    }
    return 2*cut + add;
}

void solution()
{
    int minTime = INF, ansHeight = 0;
    for(int i = minHeight; i <= maxHeight; i++) {
        int cost = getCost(i);
        if(cost <= minTime) {
            minTime = cost;
            ansHeight = i;
        }
    }
    cout << minTime << " " << ansHeight << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solution();
    
    return 0;
}