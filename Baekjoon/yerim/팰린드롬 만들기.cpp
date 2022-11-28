// [1254] 팰린드롬 만들기
#include <iostream>
using namespace std;

int len;
string s;

bool palindrome(int idx)
{
	for (int i = 0; idx + i < len - i - 1; i++) {
        if (s[idx + i] != s[len - i - 1]) {
            return false;
        }
    }
	return true;
}

void solve()
{
    int ans = 0;
    len = s.size();

	for (int i = 0; i < len; i++) {
        if (palindrome(i)) {
			ans = len + i;
			break;
		}
    }
	cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	cin >> s;
    solve();

	return 0;
}