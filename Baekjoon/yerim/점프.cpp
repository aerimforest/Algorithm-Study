// [1890] 점프
// dp
// 경로의 개수가 최대 (2^63-1)이기 때문에 bfs 사용할 경우 큐에 계속 넣었다 뺐다하는 작업으로 메모리초과 발생
#include <iostream>
using namespace std;

int n, map[101][101];
long long dp[101][101];

void input()
{
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n ; j++) {
            cin >> map[i][j];
        }
    }
}

void solve()
{
    dp[0][0] = 1;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(dp[i][j] == 0) continue;
            if(i == n-1 && j == n-1) break;

            if(i + map[i][j] < n) { // 아래쪽
                dp[i + map[i][j]][j] += dp[i][j];
            }
            if(j + map[i][j] < n) { // 오른쪽
                dp[i][j + map[i][j]] += dp[i][j];
            }
        }
    }
    cout << dp[n-1][n-1] << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}