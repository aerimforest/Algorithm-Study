// [16928] 뱀과 사다리 게임
#include <iostream>
#include <queue>
using namespace std;

bool visited[101];
int n, m, info[101];

void input()
{
    int from, to;
    cin >> n >> m;
    for(int i = 0; i < n + m; i++) {
        cin >> from >> to;
        info[from] = to;
    }
}

void bfs()
{
    queue<pair<int, int>> q; // <번호, 주사위 던진 횟수>
    q.push({1, 0});
    visited[1] = true;

    while(!q.empty()) {
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();
        printf("\ncur = %d\n", cur);
        if(cur == 100) {
            cout << cnt << '\n';
            return;
        }

        for(int i = 1; i <= 6; i++) {
            int next = cur + i;
            if(cur > 100 || visited[next]) continue;
            printf("info[%d] = %d, ", next, info[next]);
            next += info[next]; // 사다리 또는 뱀 따라 이동
            printf("next = %d\n", next);
            q.push({next, cnt+1});
            visited[next] = true;
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    bfs();

    return 0;
}