// [2302] 극장 좌석
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, seat[41], dp[41];
vector<int> between;

void input()
{
    int prev = 0, vip = 0; // 고정석이 0개 일 수 있음 -> vip 초기값 = 0
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        cin >> vip;
        between.push_back(vip - prev - 1);
        prev = vip;
    }
    between.push_back(n - vip);
}

void solve()
{
    dp[1] = 1; dp[2] = 2;
    for(int i = 3; i <= 40; i++) { 
        dp[i] = dp[i-1] + dp[i-2];
    }

    int ans = 1;
    for(int len: between) {
        if(len != 0) {
            ans *= dp[len];
        }
    }
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}