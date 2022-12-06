// [3079] 입국 심사
// 이분 탐색
#include <iostream>
using namespace std;

long long n, m, maxTime, t[100001];

void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> t[i];
        maxTime = max(maxTime, t[i]);
    }
}

void solve()
{
    long long left = 0, right = maxTime * m, ans;

    while(left <= right) {
        long long mid = (left + right) / 2;
        long long possiblePeople = 0; // mid초 동안 심사 가능한 인원

        for(int i = 0; i < n; i++) {
            possiblePeople += mid / t[i];
        }
        if(possiblePeople >= m) {
            right = mid - 1;
            ans = mid;
        }
        else {
            left = mid + 1;
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