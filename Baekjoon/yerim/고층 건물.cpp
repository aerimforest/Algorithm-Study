// [1027] 고층 건물
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> building;

void input()
{
    int height;
    cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> height;
		building.push_back(height);
	}
}

void solve(void)
{
	vector<int> count(n);
	for (int i = 0; i < n; i++) {
		double maxGradient = -1000000000;
		for (int j = i + 1; j < n; j++) {
            int x = j - i;
			int y = building[j] - building[i];
			double m = y * 1.0 / x;

			if (m <= maxGradient) continue;
			maxGradient = m;
			count[i]++; count[j]++;
		}
	}
    sort(count.rbegin(), count.rend());
	cout << count[0] << '\n';
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    input();
	solve();

    return 0;
}