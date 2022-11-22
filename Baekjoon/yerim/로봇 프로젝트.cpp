// [3649] 로봇 프로젝트
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void solve()
{
    int x, n;
	while (cin >> x >> n) {
		x *= 10000000;

        bool flag = false;
        int temp;
		vector<int> vec;

		for (int i = 0; i < n; i++) {
			cin >> temp;
			vec.push_back(temp);
		}
		sort(vec.begin(), vec.end());

        int l = 0, r = vec.size() - 1;

		while (l < r) {
			int sum = vec[l] + vec[r];
			if (sum == x) {
				flag = true;
				break;
			}
			if (sum < x) l++;
			else r--;
		}

		if (flag) cout << "yes " << vec[l] << ' ' << vec[r] << '\n';
		else cout << "danger" << '\n';
	}
}

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();

	return 0;
}