// [1182] 부분수열의 합
// 브루트포스, 백트래킹
#include <iostream>
using namespace std;

int n, s, ans = 0, num[21];

void input()
{
    cin >> n >> s;
    for(int i = 0 ; i < n ; i ++) {
        cin >> num[i];
    }   
}

void solve(int index, int sum)
{
    if(index == n) {
        if(sum == s) ans++;
        return;
    }
    solve(index + 1, sum); // index번째 요소를 더하지 않음
    solve(index + 1, sum + num[index]); // index번째 요소를 더함
}

int main(void)
{
    input();
    solve(0, 0);
    ans = (s == 0) ? ans - 1 : ans; // s = 0인 경우 공집합 제거
    cout << ans << '\n';
}