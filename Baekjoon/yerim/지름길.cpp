// [1446] 지름길
#include <iostream>
#include <vector>
using namespace std;

int n, d, from, to, cost, dp[10001];
vector<pair<int, int>> vec[10001];

void input()
{
    cin >> n >> d;
    for(int i = 0; i < n; i++) {
        cin >> from >> to >> cost;
        if(to > d || to - from < cost) continue;
        vec[to].push_back({from, cost});
    }
}

void solve()
{
    // init
    for(int i = 0; i <= d; i++) {
        dp[i] = i;
    }

    for(int i = 1; i <= d; i++) {
        dp[i] = dp[i - 1] + 1;
        for(int j = 0; j < vec[i].size(); j++) {
            dp[i] = min(dp[i], dp[vec[i][j].first] + vec[i][j].second);
        }
    }
    cout << dp[d] << '\n';
}

int main(){

    ios_base::sync_with_stdio(0),
    cin.tie(0), cout.tie(0);

    input();
    solve();

    return 0;
}