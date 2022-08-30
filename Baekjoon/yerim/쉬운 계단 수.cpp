// [10844] 쉬운 계단 수
#include <iostream>
#define MAX 1000000000
using namespace std;
// dp[i][j] = 길이가 i면서 j로 시작하는 쉬운 계단 수의 개수

long long n, dp[101][10];

int solve()
{
    for(int i = 0; i <= 9; i++) {
        dp[1][i] = 1;
    }

    for(int i = 2; i <= n; i++) {
        for(int j = 0; j <= 9; j++) {
            if(j == 0) dp[i][j] = (dp[i - 1][j + 1]) % MAX;
            else if(j == 9) dp[i][j] = (dp[i - 1][j + 1]) % MAX;
            else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MAX;
        }
    }

    long long ans = 0;
    for(int i = 1; i <= 9; i++) {
        ans += dp[n][i];
    }
    return ans % MAX;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    cout << solve() << '\n';

    return 0;
}