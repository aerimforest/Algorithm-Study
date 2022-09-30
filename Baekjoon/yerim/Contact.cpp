// [1013] Contact
#include <iostream>
#include <string>
#include <regex>
using namespace std;

void solve(void)
{
    string bits;
	cin >> bits;

	regex pattern("(100+1+|01)+");
	cout << (regex_match(bits, pattern) ? "YES\n" : "NO\n");
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	cin >> t;
    while(t--) {
        solve();
    }
	return 0;
}