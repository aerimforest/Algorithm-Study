// [21758] 꿀 따기
#include <iostream>
using namespace std;

int dp[100001]; // 0 ~ i까지의 벌꿀 합 
int n, map[100001];

void input()
{
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> map[i];
        dp[i] = dp[i-1] + map[i];
    }  
}

int getHoney()
{
    int ans = 0;
    // 벌 -> 벌 -> 벌통
    ans = max(ans, (dp[n] - dp[2]) * 2);
    for(int i = 2; i <= n-1; i++) { // 두번째 벌의 위치
        ans = max(ans, dp[n] - map[1] - map[i] + dp[n] - dp[i]);
    }

    // 벌통 -> 벌 -> 벌
    for(int i = 2; i <= n-1; i++) { // 두번째 벌의 위치
        ans = max(ans, dp[i-1] + dp[n-1] - map[i]);
    }

    // 벌 -> 벌통 -> 벌
    for(int i = 2; i <= n-1; i++) {
        ans = max(ans, (dp[i] - map[1]) + (dp[n-1] - dp[i-1]));
    }
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    cout << getHoney() << '\n';

    return 0;
}