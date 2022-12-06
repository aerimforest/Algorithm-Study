// [15565] 귀여운 라이언
// 투포인터, 슬라이딩 윈도우
#include <iostream>
#include <vector>
#define MAX 1000001
using namespace std;

int n, k;
vector<int> rionPos;

void input()
{
    int doll;
    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> doll;
        if(doll == 1) rionPos.push_back(i);
    }
}

void solve()
{
    int ans = MAX;
    if(rionPos.size() < k) {
        cout << "-1\n";
    }
    else {
        for(int i = 0; i <= rionPos.size() - k; i++) {
            ans = min(ans, rionPos[i+k-1] - rionPos[i] + 1);
        }
        cout << ans << '\n';
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}