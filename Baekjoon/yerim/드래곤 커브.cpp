// [15685] 드래곤 커브
#include <iostream>
#include <vector>
using namespace std;

bool dragonCurve[101][101];
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, -1, 0, 1};
vector<int> dirList;

void setDir(int dir, int level)
{
    dirList.clear();
    dirList.push_back(dir);
    for(int i = 1; i <= level; i++) {
        for(int j = dirList.size() - 1; j >= 0; j--) {
            if(dirList[j] + 1 > 3) dirList.push_back(0);
            else dirList.push_back(dirList[j] + 1);
        }
    }
}

void setDragonCurve(int x, int y)
{
    int nx = x, ny = y;
    for(int i = 0; i < dirList.size(); i++) {
        int dir = dirList[i];
        nx += dx[dir]; ny += dy[dir];
        if(dragonCurve[ny][nx] == true || nx < 0 || nx > 100 || ny < 0 || ny > 100) {
            continue;
        }
        dragonCurve[ny][nx] = true;
    }
}

void printAns()
{
    int ans = 0;
    for(int i = 0; i < 100; i++) {
        for(int j = 0; j < 100; j++) {
            if(dragonCurve[i][j] && dragonCurve[i+1][j] && dragonCurve[i][j+1] && dragonCurve[i+1][j+1]) {
                ans++;
            }
        }
    }
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, x, y, d, g;
    cin >> n;
    while(n--) {
        cin >> x >> y >> d >> g;
        dragonCurve[y][x] = true;
        setDir(d, g);
        setDragonCurve(x, y);
    }
    printAns();

    return 0;
}