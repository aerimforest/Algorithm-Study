#include <iostream>
using namespace std;

int arr[200000], cnt[100001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
    int n, k;
	cin >> n >> k;

	int answer = 0, start = 0;

	for (int i = 0; i < n; i++) {
		cin >>arr[i];
		cnt[arr[i]]++;
        
		while(cnt[arr[i]] > k) {
			cnt[arr[start++]]--;
		}
		answer = max(answer, i-start+1);
	}
	cout << answer;

	return 0;
}