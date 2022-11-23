// [13702] 이상한 술집
#include <iostream>
using namespace std;
long long n, k, maxCapacity, capacity[10000];

void input()
{
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> capacity[i];
        maxCapacity = max(maxCapacity, capacity[i]);
    }
}

void solve()
{
    long long l = 1, r = maxCapacity, mid, cnt, ans = 0;
    while (l <= r) {
        cnt = 0;
        mid = (l + r) / 2;
        for (int i = 0; i < n; i++) {
            cnt += capacity[i] / mid;
        }
        if (cnt >= k) {
            if (ans < mid)
                ans = mid;
            l = mid + 1;
        }
        else {
            r = mid - 1;
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