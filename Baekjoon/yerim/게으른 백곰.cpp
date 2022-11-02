// [10025] 게으른 백곰
#include <iostream>
using namespace std;

int n, k, ans;
int bucket[1000001]; // arr[i] = i 위치에 있는 얼음의 양

void input()
{
    int pos, ice;
    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> ice >> pos;
        bucket[pos] = ice;
    }
}

void solve()
{
    int sum = 0, range = 2*k + 1; 

    for(int i = 0; i <= 1000000; i++) {
        // 0~2*k 이후부터는 sum에서 ((현재 위치 - 범위)의 얼음양) 빼기
        if(i >= range) { 
            sum -= bucket[i - range];
        }

        sum += bucket[i]; // 현재 위치 얼음양 더하기
        ans = max(ans, sum);
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