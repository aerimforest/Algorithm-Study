// [2212] 센서
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, k, pos[10000], diff[10000];

void input()
{
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> pos[i];
    }
}

void solve()
{
    int ans = 0;

    sort(pos, pos + n);
    for(int i = 1; i < n; i++){
        diff[i - 1] = pos[i] - pos[i - 1];
    }

    sort(diff, diff + n);
    for(int i = 0; i < n - k + 1; i++){
        ans += diff[i];
    }
    cout << ans << '\n';
}

int main(void){
    input();
    solve();
    return 0;
}