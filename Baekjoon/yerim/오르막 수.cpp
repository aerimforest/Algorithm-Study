// [11057] 오르막 수
// dp[i][j] = dp[오르막 수의 길이][첫 자릿수]
#include <cstdio>
using namespace std;

int N, ans, dp[1001][10];

void solve()
{
    for (int i = 0; i < 10; i++) {
        dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < 10; j++) {
            for (int k = j; k < 10; k++) {
                dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
            }
        }
    }

    for (int i = 0; i < 10; i++) {
        ans = (ans + dp[N][i]) % 10007;
    }

    printf("%d\n", ans);
}

int main() 
{
    scanf("%d", &N);
    solve();

    return 0;
}