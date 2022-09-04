// [11052] 카드 구매하기
#include <iostream>
using namespace std;

int n, p[1001], dp[1001];

void input()
{
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> p[i];
    }
}

void getMaxCost()
{
    dp[0] = 0; dp[1] = p[1];
    for(int i = 2; i <= n; i++) {
        for(int j = i; j >= 1; j--) {
            dp[i] = max(dp[i], p[j] + dp[i - j]);
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    getMaxCost();
    cout << dp[n] << '\n';

    return 0;
}