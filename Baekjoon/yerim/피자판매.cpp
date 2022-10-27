// [2632] 피자판매
#include <iostream>
using namespace std;
 
int k, n, m, ans;
int A[1000], B[1000], Acnt[2000001], Bcnt[2000001];

void input()
{
    cin >> k >> n >> m;
    for (int i = 0; i < n; i++) cin >> A[i];
    for (int i = 0; i < m; i++) cin >> B[i];
}
 
void solve(int piece, int arr[], int arrCnt[]) {
    for (int i = 1; i <= piece; i++) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += arr[j];
        }
        arrCnt[sum]++;

        if (sum == k) ans++;
        if (i == piece) break;
        for (int j = 1; j < piece; j++) {
            sum -= arr[j - 1];
            sum += arr[(j + i - 1) % piece];
            arrCnt[sum]++;
            if (sum == k) ans++;
        }
    }
}

void output()
{
    for (int i = 1; i < k; i++) {
        int j = k - i;
        ans += Acnt[i] * Bcnt[j];
    }
    cout << ans << '\n';
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve(n, A, Acnt);
    solve(m, B, Bcnt);
    output();

    return 0;
}
