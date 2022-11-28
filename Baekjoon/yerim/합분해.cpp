// [2225] 합분해
// dp
#include <iostream>
using namespace std;

int n, k;
long dp[201][201];

void init()
{
    for (int i = 0; i < 201; i++) {
		dp[0][i] = 0;
		dp[1][i] = i;
		dp[i][0] = 0;
	}
}

void solve()
{
    init();
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			dp[i][j] %= 1000000000;
		}
	}
	cout << dp[n][k] << '\n';
}

int main(void)
{
	cin >> n >> k;
    solve();
    return 0;
}