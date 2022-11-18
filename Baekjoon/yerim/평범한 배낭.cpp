// [12865] 평범한 배낭
// dp[i][j] = dp[배낭에 넣을 물건 번호][현재 배낭의 무게] = 현재 배낭까지의 최대 가치
#include <iostream>
using namespace std;

int n, k;
int w[101], v[101], dp[101][100001];

void input()
{
    cin >> n >> k;
    for(int i = 1; i <= n; i++) {
        cin >> w[i] >> v[i];
    }
}

void solve()
{   
    for (int i = 1; i <= n; i++) { // 가방 번호
		for (int j = 1; j <= k; j++) { // 무게
			if (j >= w[i]) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
			else {
                dp[i][j] = dp[i - 1][j];
            }
		}
	}

    cout << dp[n][k] << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    input();
    solve();

    return 0;
}