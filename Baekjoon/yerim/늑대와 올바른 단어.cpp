// [13022] 늑대와 올바른 단어
#include <iostream>
#include <vector>
using namespace std;

string str;

void solve()
{
    int idx = 0;
    while(idx <= str.size()) {
        int n = 0;
        while(str[idx + n] == 'w') {
            n++;
        }
        if(n == 0) {
            cout << "0\n";
            return;
        }
        for(int i = idx + n; i < idx + n * 2; i++) {
            if(str[i] != 'o') {
                cout << "0\n";
                return;
            }
        }
        for(int i = idx + n*2; i < idx + n*3; i++) {
            if(str[i] != 'l') {
                cout << "0\n";
                return;
            }
        }
        for(int i = idx + n*3; i < idx + n*4; i++) {
            if(str[i] != 'f') {
                cout << "0\n";
                return;
            }
        }
        idx += n*4;
        if(idx  == str.size()) {
            cout << "1\n";
            return;
        }
    }
    cout << "0\n";
}

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >>str;
    solve();
    
    return 0;
}