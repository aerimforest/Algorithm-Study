// [14501] 퇴사
// dp[i] = i번째 날부터 마지막날까지의 최대 이익
#include <iostream>
using namespace std;

int n, t[16], p[16], dp[16];

int max(int a, int b)
{
    if(a > b) return a;
    else return b;
}

void getMaxProfit()
{   
    dp[n] = (t[n] == 1) ? p[n] : 0;
    for(int i = n-1; i >= 1; i--) {
        if(i + t[i] <= n + 1) {
            dp[i] = max(dp[i+1], p[i] + dp[i + t[i]]);
        }
        else {
            dp[i] = dp[i+1];
        }
    }
}

void input()
{
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> t[i] >> p[i];
    }
}

int main(void)
{
    input();
    getMaxProfit();
    cout << dp[1] << '\n';
}