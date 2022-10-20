// [2961] 도영이가 만든 맛있는 음식
// 비트마스킹
#include <iostream>
#include <cmath>
using namespace std;

int n, info[11][2];
long long ans = 10000000000;

void input()
{
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> info[i][0] >> info[i][1];
    }   
}

void solve()
{
    for(int i = 1; i <= (1 << n) - 1; i++) {
        long long a = 1, b = 0;
        for(int j = 0; j < n; j++) {
            if(i & (1 << j)) {
                a *= info[j][0];
                b += info[j][1];
            }
        }
        ans = min(ans, abs(a-b));
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