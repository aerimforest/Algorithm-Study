// [1715] 카드 정렬하기
#include <iostream>
#include <queue>
using namespace std;

int n;
priority_queue<int, vector<int>, greater<int>> pq;

void input()
{
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int a;
        cin >> a;
        pq.push(a);
    }
}

void solve()
{
    if(n == 1) {
        cout << 0 << '\n';
        return;
    }

    int ans = 0, a, b;
    while(pq.size() > 1) {
        a = pq.top(); pq.pop();
        b = pq.top(); pq.pop();
        ans += (a + b);
        pq.push(a + b);
    }
    cout << ans << '\n';
}

int main() 
{
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);

    input();
    solve();

    return 0;
}