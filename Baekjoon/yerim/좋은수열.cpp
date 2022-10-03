// [2661] 좋은수열
#include <iostream>
#include <cstring>
using namespace std;

int n;

void input()
{
    cin >> n;
}

void dfs(string str, char num)
{
    str += num;
 
    bool flag = true;
    int len = str.length();
    
    for(int i = len - 1; i >= len/2; i--) {
        int gap = len - i;
        if(i - gap < 0) break;
        if(str.substr(i, gap) == str.substr(i - gap, gap)) {
            flag = false;
            break;
        }
    }
    if(flag == false) return;

    if(len == n) {
        cout << str << '\n';
        exit(0);
    }

    for(int i = 1; i <= 3; i++) {
        dfs(str, '0' + i);
    }
}

void solve()
{
    if(n == 1) cout << "1" << '\n';
    else {
        for(int i = 1; i <= 3; i++) {
            dfs("1", '0' + i);
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