// [17142] 연구소 3
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n, m, virusNum, totalEmptySpace, ans = 987654321; 
int state[51][51], selectedList[11], visited[51][51];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
vector<int> timeList;
vector<pair<int, int>> virusPos;
struct Info {
    int x;
    int y;
};

void spreadVirus()
{
    int time = 0, emptySpace = 0;
    queue<Info> q;
    memset(visited, -1, sizeof(visited));

    for(int i = 0; i < m; i++) {
        visited[virusPos[i].first][virusPos[i].second] = 0;
        Info info = {virusPos[i].first, virusPos[i].second};
        q.push(info);
    }

    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(state[nx][ny] == 1 || nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if(visited[nx][ny] == -1) { // 감염되지 않음
                visited[nx][ny] = visited[x][y] + 1;   
                if(state[nx][ny] == 0) {
                    emptySpace++;
                    time = visited[nx][ny];
                }
                Info info = {nx, ny};
                q.push(info);
            }
        }
    }
    if(emptySpace == totalEmptySpace) {
        ans = min(ans, time);
    }
}

void selectVirus(int idx, int depth)
{
    if(depth == m) {
        cout << "\n선택\n";
        for(int i = 0; i < m; i++) {
            cout << selectedList[i] << " ";
        }
        cout << '\n';
        spreadVirus();
        return;
    }

    for(int i = idx + 1; i < virusNum; i++) {
        selectedList[depth] = i;
        selectVirus(i, depth + 1);
    }
}

int getMinTime()
{
    selectVirus(-1, 0);
    if(ans == 987654321) return -1;
    else return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> state[i][j];
            if(state[i][j] == 0) totalEmptySpace++;
            else if(state[i][j] == 2) {
                virusNum++;
                virusPos.push_back(make_pair(i, j));
            }
        }
    }    
    cout << getMinTime() << '\n';

    return 0;
}
