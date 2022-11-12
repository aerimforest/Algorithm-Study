// [1932] 정수 삼각형
#include <iostream>
#include <algorithm>
using namespace std;

int n, sum = 0;
int dp[505][505], triangle[505][505];

void input()
{
    cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> triangle[i][j];
		}
	}
}

void solve()
{   
    for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			dp[i][j] = triangle[i][j] + max(dp[i - 1][j], dp[i - 1][j - 1]);
		}
	}

	for (int i = 1; i <= n; i++) {
		sum = max(sum, dp[n][i]);
	}

	cout << sum << endl;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}