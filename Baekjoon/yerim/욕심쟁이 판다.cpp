// [1937] 욕심쟁이 판다
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, answer;
int map[501][501], dp[501][501];
int dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};

void input()
{
    cin >> n;
	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }
}

int solve(int x, int y)
{
	if (dp[x][y] != 0) return dp[x][y];
	dp[x][y] = 1;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < n && nx >= 0 && ny < n && ny >= 0) {
			if (map[nx][ny] > map[x][y]) {
				dp[x][y] = max(dp[x][y], solve(nx, ny) + 1);
			}
		}
	}
	return dp[x][y];
}

int main()
{
    input();

	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
			answer = max(answer, solve(i, j));
		}
    }

	cout << answer << '\n';
	return 0;
}