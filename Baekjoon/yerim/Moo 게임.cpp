// [5904] Moo 게임
#include <iostream>
using namespace std;

int n;

void input()
{
    cin >> n;
}

void getNstChar(int k, long long len)
{
    int prevLen = (len - (k+3)) / 2;

    if(n <= 3) {
        cout << ((n == 1) ? 'm' : 'o') << '\n';
        return;
    }

    if(prevLen + 1 == n) cout << "m" << '\n';
    else if(prevLen + 2 <= n && n <= prevLen + k + 3) cout << "o" << '\n';
    else if(prevLen + k + 3 < n){
        n = (n - prevLen - k - 3);
        getNstChar(k-1, prevLen);
    }
    else {
        getNstChar(k-1, prevLen);
    }
}

void solve()
{
    long long len = 0;
    for(int k = 0;; k++) {
        len = 2*len + k + 3;
        if(len >= n) {
            getNstChar(k, len);
            break;
        }
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