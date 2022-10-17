// [4485] 녹색 옷 입은 애가 젤다지?
// dp[i][j] = (i, j) 까지 잃어버려야 하는 최소 금액
#include <iostream>
#include <queue>
using namespace std;

int n;
int arr[130][130], dp[130][130];
int dy[4] = { 0,0,-1,1 }, dx[4] = { 1,-1,0,0 };

void bfs() {

	queue <pair<int, int>> pq;
	pq.push(make_pair(0, 0));
	dp[0][0] = arr[0][0];
    
	while (!pq.empty()) {
		int y = pq.front().first;
		int x = pq.front().second;
		pq.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
				if (dp[ny][nx] > dp[y][x] + arr[ny][nx]) {
					dp[ny][nx] = dp[y][x] + arr[ny][nx];
					pq.push(make_pair(ny, nx));
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);

	int cnt = 1;

	while (true) {
		cin >> n;
		if (n == 0)
			break;

		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
				dp[i][j] = 2000000000;
			}
        }
		bfs();
		cout << "Problem " << cnt++ << ": " << dp[n - 1][n - 1] << "\n";
	}

	return 0;
}