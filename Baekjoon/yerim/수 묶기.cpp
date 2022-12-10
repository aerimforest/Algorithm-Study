// [1744] 수 묶기
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
long long ans = 0;
vector <int> negative, positive;

void input()
{
    cin >> n;
    for(int i = 0 ; i < n ; i++) {
        int tmp;
        cin >> tmp;
        if(tmp > 0) positive.push_back(tmp);
        else negative.push_back(tmp);
    }
}

void solve()
{
    sort(positive.begin(), positive.end());
    sort(negative.begin(), negative.end());

    // positive
    for(int i = positive.size() - 1; i >= 0; i -= 2) {
        // 전체 숫자의 개수가 홀수개인 경우 -> 첫번째 원소(양수 중 가장 작은 수)는 무조건 더해줘야 함
        if(i == 0) {
            ans += positive[i];
            break;
        }
        // 가장 작은 양수가 1인 경우 곱하는 것보다 더하는 것이 더욱 큰 값이 됨
        else if(positive[i-1] == 1) {
            ans += positive[i] + positive[i-1];
            continue;
        }
        ans += positive[i]*positive[i-1];
    }

    // negative
    for(int i = 0; i < negative.size(); i += 2) {
        if(i == negative.size() - 1) {
            ans += negative[i];
            break;
        }
        ans += negative[i]*negative[i+1];
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