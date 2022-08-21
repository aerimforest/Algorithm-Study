// [15684] 사다리 조작
// 구현, 브루트포스, 백트래킹
#include <iostream>
#include <algorithm>
using namespace std;
 
bool map[32][12];
int n, m, h, ans = 987654321;

void input()
{
    int a, b;
    cin >> n >> m >> h;
    for(int i = 0; i < m; i++) {
        cin >> a >> b;
        map[a][b] = true;
    }
}
 
bool startLadder() {
    for(int i = 1; i <= n; i++) {
        int dest = i;
        for(int j = 1; j <= h; j++) {
            if(map[j][dest] == true) dest++;
            else if(map[j][dest - 1] == true) dest--;
        }
        if(dest != i) return false;
    }
    return true;
}
 
void selectLines(int x, int y, int depth) {
    if(depth == 4) return; // 추가한 가로선 개수가 4개 이상인 경우 정답으로 간주하지 않음 -> 볼 필요 없음
    if(startLadder() == true) {
        ans = min(ans, depth);
        return;
    }
 
    for(int i = y; i <= h; i++) {
        for(int j = x; j <= n; j++) {
            if(map[i][j] == false && map[i][j - 1] == false && map[i][j + 1] == false) {
                map[i][j] = true;
                selectLines(j, i, depth + 1);
                map[i][j] = false;
            }
        }
        x = 1;
    }
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    selectLines(1, 1, 0);

    if(ans > 3) cout << "-1\n";
    else cout << ans << '\n';
    
    return 0;
}