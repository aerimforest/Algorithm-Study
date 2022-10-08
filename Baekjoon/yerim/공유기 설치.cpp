// [2110] 공유기 설치
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, c;
vector<int> homes;

void input()
{
    int num;
    cin >> n >> c;
    for(int i = 0; i < n; i++) {
        cin >> num;
        homes.push_back(num);
    }
}

void solve()
{
    int left = 1, right = homes[n-1], minDist, ans = 0;
    sort(homes.begin(), homes.end());

    while(left <= right) {
        int cnt = 1; // 첫번째 집에는 무조건 공유기 설치
        int prev = homes[0];
		
		minDist = (left + right) / 2;
		
        for(int i = 1; i < n; i++) {
            if(homes[i] - prev >= minDist) {
                prev = homes[i];
                cnt++;
            }
        }

        if(cnt < c) right = minDist - 1;
		else if(cnt >= c) {
			left = minDist + 1;
			ans = minDist; // cnt == c라고 해서 바로 답 X, cnt == c 만족하는 더 큰 간격 존재할 수 있음
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