// [9519] 졸려
#include <iostream>	
using namespace std;

int blink;
string word;

void solve()
{
    int cnt = 0;
    string ans = word, tmp = word;
	for (int k = 0; k < blink; k++) {
		for (int i = 0; i < word.length(); i += 2) {
			ans[i / 2] = word[i];
			ans[word.length() - i / 2 - 1] = word[i + 1];
		}
		if (word.length() % 2 == 1) {
			ans[word.length() / 2] = word[word.length() - 1];
		}
		word = ans;
		cnt++;
		if (tmp == ans) break;
	}
	blink %= cnt;
	for (int k = 0; k < blink; k++) {
		for (int i = 0; i < word.length(); i += 2) {
			ans[i / 2] = word[i];
			ans[word.length() - i / 2 - 1] = word[i + 1];
		}
		if (word.length() % 2 == 1) {
			ans[word.length() / 2] = word[word.length() - 1];
		}
		word = ans;
	}
	cout << ans;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	cin >> blink >> word;

    solve();

	return 0;
}