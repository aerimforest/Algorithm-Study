// [11066] 파일 합치기
#include<iostream>
#include <algorithm>
#define INF 1000000007
using namespace std;
 
int dp[501][501], cost[501], sum[501];

void solve()
{
    int t, k;
    cin >> t;

    while (t--) {
        cin >> k;
        for (int i = 1; i <= k; i++) {
            cin >> cost[i];
            sum[i] = sum[i - 1] + cost[i];
        }
 
        for (int i = 1; i < k; i++) {
            for (int j = 1; j + i <= k; j++) {
                int p = j + i;
                dp[j][p] = INF;
 
                for (int mid = j; mid < p; mid++)
                    dp[j][p] = min(dp[j][p], dp[j][mid] + dp[mid + 1][p] + sum[p] - sum[j - 1]);
            }
        }
        cout << dp[1][k] << endl;
    }
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();
    return 0;
}