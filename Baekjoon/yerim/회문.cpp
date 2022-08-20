// [17609] 회문
#include <iostream>
using namespace std;

string str;

int isPalindrome(int left, int right, bool pseudoPossible) {
    while(left < right) {
        if(str[left] != str[right]) {
            if(pseudoPossible) {
                if(isPalindrome(left + 1, right, false) == 0 || isPalindrome(left, right - 1, false) == 0) 
                return 1;
            }
            return 2;
        }
        left++; right--;
    }
    return 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
  
    int t;
    cin >> t;
    while(t--) {
        cin >> str;
        cout << isPalindrome(0, str.length() - 1, true) << '\n';
    }
    return 0;
}