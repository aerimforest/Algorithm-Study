// [1743] 음식물 피하기
#include <iostream>
using namespace std;

int n, m, k, trashSize = 0;
int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};
bool trash[101][101];

void input()
{
    int x, y;
    cin >> n >> m >> k;
    for(int i = 0; i < k; i++) {
        cin >> x >> y;
        trash[x][y] = true;
    }
}

void dfs(int x, int y)
{
    trashSize++;
    trash[x][y] = false;

    for(int i = 0; i < 4; i++) {
        if(x + dx[i] >= 1 && x + dx[i] <= n && y + dy[i] >= 1 && y + dy[i] <= m) {
            if(trash[x + dx[i]][y + dy[i]] == true) {
                dfs(x + dx[i], y + dy[i]);
            }
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int maxSize = 0;

    input();
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if(trash[i][j] == true) {
                trashSize = 0;
                dfs(i, j);
                maxSize = trashSize > maxSize ? trashSize : maxSize;
            }
        }
    }

    cout << maxSize << '\n';
    return 0;
}