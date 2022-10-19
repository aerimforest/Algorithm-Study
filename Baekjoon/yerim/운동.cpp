// [1956] 운동
// 플로이드 워셜
#include <iostream>
#define INF 987654321
using namespace std;

int v, e, cost[401][401];

void input()
{
    int a, b, c;
    for(int i = 0; i < e; i++) {
        cin >> a >> b >> c;
        cost[a][b] = c;
    }
}

void init()
{
    for(int i = 1; i <= v; i++) {
        for(int j = 1; j <= v; j++) {
            cost[i][j] = INF;
        }
    }
}

void solve()
{
    for(int k = 1; k <= v; k++) { // 경유지
        for(int i = 1; i <= v; i++) { // 출발지
            for(int j = 1; j <= v; j++) { // 도착지
                if(cost[i][k] + cost[k][j] < cost[i][j]) {
                    cost[i][j] = cost[i][k] + cost[k][j];
                }
            }
        }
    }
}

void output()
{
    int ans = INF;
    for(int i = 1; i <= v; i++) {
        if(cost[i][i] < ans && cost[i][i] != 0) {
            ans = cost[i][i];
        }
    }
    ans = (ans == INF) ? -1 : ans;
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> v >> e;
    init();
    input();
    solve();
    output();

    return 0;
}