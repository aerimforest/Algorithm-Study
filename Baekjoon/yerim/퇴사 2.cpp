// [15486] 퇴사 2
// dp
#include <iostream>
#define MAX 1500001
using namespace std;

int n, t[MAX], p[MAX], dp[MAX];

void getMaxProfit()
{
    for(int i = n; i >= 1; i--) {
        if(i + t[i] <= n + 1) {
            dp[i] = max(dp[i+1], p[i] + dp[i + t[i]]);
        }
        else {
            dp[i] = dp[i+1];
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> t[i] >> p[i];
    }
    getMaxProfit();
    cout << dp[1] << '\n';

    return 0;
}