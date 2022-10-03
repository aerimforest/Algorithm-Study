// [1182] 부분수열의 합
#include <iostream>
using namespace std;

int n, s, ans, arr[21];

void input()
{
    cin >> n >> s;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
}

void dfs(int idx, int sum, int cnt)
{
    if(idx == n) {
        if(sum == s && cnt >= 1) {
            ans++;
        }
        return;
    }

    dfs(idx + 1, sum, cnt);
    dfs(idx + 1, sum + arr[idx], cnt + 1);
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    dfs(0, 0, 0);
    cout << ans << '\n';

    return 0;
}