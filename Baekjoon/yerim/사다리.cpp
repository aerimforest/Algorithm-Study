// [2022] 사다리
// 이분탐색
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

double x, y, c;

void solve()
{
    double l = 0, r = min(x, y);

	while (r - l >= 1e-3) {
		double w = (l + r) / 2;
		double h1 = sqrt(pow(x, 2) - pow(w, 2));
		double h2 = sqrt(pow(y, 2) - pow(w, 2));
		double num = h1 * h2 / (h1 + h2);

		if (num < c) r = w;
		else l = w;
	}
	cout << fixed;
	cout.precision(3);
	cout << r << '\n';
}

int main() 
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> x >> y >> c;
    solve();
	
    return 0;
}