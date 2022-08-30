// [2293] 동전 1
// dp[j] = value[i]를 사용하지 않고 만들었던 경우의 수 + value[i]를 사용해서 만드는 경우의 수 
#include <iostream>
using namespace std;

int value[101], dp[10001];

int main() {
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <=n; i++) {
        cin >> value[i];
    }

    dp[0] = 1; // 0원을 만들기 위해서는 어떤 동전도 사용하지 않으면 됨
    for (int i = 1; i <= n; i++) {
        for (int j = value[i]; j <= k; j++) {
            dp[j] += dp[j - value[i]];
        }
    }
    cout << dp[k] << '\n';
    return 0;
}