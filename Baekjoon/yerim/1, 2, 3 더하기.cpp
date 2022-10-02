// [9095] 1, 2, 3 더하기
#include <iostream>
using namespace std; 

int dp[12] = { 0, 1, 2, 4, };

void init()
{
    for(int i = 4; i <= 11; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]);
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, n;
    cin >> t;
    init();
    while(t--) {
        cin >> n;
        cout << dp[n] << '\n';
    }

    return 0;
}