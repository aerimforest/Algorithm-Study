// [1802] 종이 접기
#include <iostream>
#include <cstring>
using namespace std;

char paper[3001];

bool check(int s, int e)
{
    int l = s, r = e;
    if(s >= e) return true;
    while(l < r) {
        if(paper[l] == paper[r]) return false;
        l++;
        r--;
    }
    return check(s, r-1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;

    cin >> t;
    while(t--) {
        cin >> paper;
        int len = strlen(paper);
        if(len % 2 == 0) cout << "NO" << '\n';
        else if(check(0, len-1)) cout << "YES" << '\n';
        else cout << "NO" << '\n';
    }
    return 0;
}