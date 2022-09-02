// [2467] 용액
#include <iostream>
#include <climits>
using namespace std;

int n, liquid[100001];

void input()
{
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> liquid[i];
    }
}

void solve()
{
    int l = 0, r = n - 1, a, b, sum = INT_MAX;
    while(l < r){
        int tmpSum = liquid[l] + liquid[r];
        if(abs(sum) > abs(tmpSum)) {
            sum = tmpSum;
            a = liquid[l];
            b = liquid[r];
        }
        if(tmpSum == 0) break;
        else if(tmpSum > 0) r--;
        else l++;
    }   
    cout << a << ' ' << b << '\n';
}

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
    return 0;
}