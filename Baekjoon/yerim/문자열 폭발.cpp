// [9935] 문자열 폭발
#include <iostream>
using namespace std;

string str, explodeStr, ansStr;

void startExplosion()
{
    int len = explodeStr.size();
    char lastChar = explodeStr[explodeStr.size() - 1];
    for(int i = 0; i < str.size(); i++) {
        ansStr += str[i];
        if(str[i] == lastChar && ansStr.size() >= len) {
            if(ansStr.substr(ansStr.size() - len) == explodeStr) {
                ansStr.erase(ansStr.size() - len); 
            }
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> str >> explodeStr;
    startExplosion();
    if(ansStr.size() > 0) cout << ansStr << '\n';
    else cout << "FRULA\n";

    return 0;
}