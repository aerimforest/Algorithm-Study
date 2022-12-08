// [11060] 점프 점프
// bfs, dp
#include <iostream>
#include <queue>
using namespace std;

bool visited[1001];
int n, a[1001];

void input()
{   
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
}

void bfs()
{
    queue<pair<int, int>> q;
    q.push({0, 0});
    visited[0] = true;

    while(!q.empty()) {
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();

        if(cur == n-1) {
            cout << cnt << '\n';
            return;
        }

        for(int i = 0; i <= a[cur]; i++) {
            if(cur + i < n && !visited[cur + i]) {
                visited[cur + i] = true;
                q.push({cur + i, cnt + 1});
            } 
        }
    }
    cout << "-1\n"; // 가장 오른쪽 끝으로 갈 수 없는 경우
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    bfs();

    return 0;
}