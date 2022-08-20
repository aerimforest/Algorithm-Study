// [12904] A와 B
#include <iostream>
#include <algorithm>
using namespace std;

string s, t;

bool isChangable()
{
    for(int i = t.size() - 1; i >= 0; i--) {
        if(t.substr(0, i + 1) == s) return true;
        if(t[i] == 'B') {
            reverse(t.begin(), t.begin() + i);
        }
    }
    return false;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> s >> t;
    if(isChangable()) cout << "1\n";
    else cout << "0\n";

    return 0;
}