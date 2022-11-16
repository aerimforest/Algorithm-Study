// [8983] 사냥꾼
#include <iostream>
#include <algorithm>
#include <cmath>
#define MAX 100001
using namespace std;

int M, N, L;
int x[MAX], y[MAX], arr[MAX];

void input()
{
    cin >> M >> N >> L;
    for(int i = 0; i < M; i++) {
        cin >> arr[i];
    }
    for(int i = 0; i < N; i++) {
        cin >> x[i] >> y[i];
    }
}

void solve()
{
    int ans = 0;

    sort(arr, arr + M);
    for(int i = 0; i < N; i++){
        int l = 0, r = M - 1, mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            int dist = abs(arr[mid] - x[i]) + y[i];
            if(dist <= L){
                ans++;
                break;
            }
            else{
                if(x[i] >= arr[mid]) l = mid + 1;
                else r = mid - 1;
            }
        }
    }
    cout << ans << '\n';
}

int main() 
{
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); cout.tie(NULL);

    input();
    solve();

    return 0;
}