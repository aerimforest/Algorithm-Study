// [15566] 개구리 1
#include <iostream>
using namespace std;

bool ansFlag;
int n, m;
int seat[16], ans[16];
int interest[16][4], favoriteLotus[16][2], pathTopic[16][16];

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++) { 
		cin >> interest[i][0] >> interest[i][1] >> interest[i][2] >> interest[i][3];
	}
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		favoriteLotus[i][0] = a - 1;
		favoriteLotus[i][1] = b - 1;
	}
	for (int i = 0; i < m; i++) { 
		int a, b, t;
		cin >> a >> b >> t;
		a--; b--; t--;
		pathTopic[a][b] = t;
		pathTopic[b][a] = t;
	}
}

bool isValid() {
	bool flag = true;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i != j && pathTopic[i][j] != 0) { // 연결되어있다면
				int topic = pathTopic[i][j];
				if (interest[seat[i]][topic] != interest[seat[j]][topic]) {
					flag = false;
					break;
				}
			}
		}
	}
	if (flag) {
		for (int i = 0; i < n; i++) {
			ans[i] = seat[i] + 1;
		}
	}
	return flag;
}

bool bfs(int idx) {
	if (idx == n) {
		if (isValid()) {
			ansFlag = true;
			return true;
		}
		return false;
	}
	for (int i = 0; i < 2; i++) {
		int tmpSeat = favoriteLotus[idx][i];
		if (seat[tmpSeat] == -1) {
			seat[tmpSeat] = idx;
			if (bfs(idx + 1)) {
                return true;
            }
			seat[tmpSeat] = -1;
		}
	}
	return false;
}

void solve()
{
    // init
    for (int i = 0; i < n; i++) {
		seat[i] = -1;
	}
    bfs(0);
}

void output()
{
    if (ansFlag) {
		cout << "YES\n";
		for (int i = 0; i < n; i++) {
			cout << ans[i] << " ";
		}
        cout << '\n';
	}
	else {
		cout << "NO\n";
	}
}

int main() 
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    input();
    solve();
    output();

	return 0;
}