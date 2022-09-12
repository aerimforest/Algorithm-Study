// [9465] 스티커
#include <iostream>
using namespace std;

int n, dp[2][100001];

void solve()
{
    dp[0][0] = dp[1][0] = 0;
    for (int i = 2; i <= n; i++) {
        dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + dp[0][i];
        dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + dp[1][i];
    }
    int answer = max(dp[1][n], dp[0][n]);
    cout << answer << '\n';
}

void input()
{
    int t;
	cin >> t;
	while(t--) {
		cin >> n;
		for (int i = 1; i <= n; i++) cin >> dp[0][i];
		for (int i = 1; i <= n; i++) cin >> dp[1][i];
        solve();
	}
}

int main() 
{
	ios::sync_with_stdio(false);
	cin.tie(0);

    input();

	return 0;
}