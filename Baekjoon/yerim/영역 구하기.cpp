// [2583] 영역 구하기
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int m, n, cnt = 0;
int maze[101][101] = { 0, };
int dx[4] = { -1, 0, 1, 0 }, dy[4] = { 0, 1, 0, -1 };
vector<int>area;

void bfs(int x, int y)
{
	int sum = 0; 
	queue<pair<int, int> >q;
	q.push(make_pair(x, y));
	maze[x][y] = 2;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		sum++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < m && 0 <= ny && ny < n && maze[nx][ny] == 0) {
				maze[nx][ny] = 2;
				q.push(make_pair(nx, ny));
			}
		}
	}
	area.push_back(sum);
	cnt++; 
}

void solve()
{
    for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (maze[i][j] == 0) {
                bfs(i, j);
            }
		}
	}
	cout << cnt << endl;
	sort(area.begin(), area.end());
	for (int i = 0; i < area.size(); i++) {
		cout << area[i] << " ";
	}
    cout << '\n';
}

void input()
{
    int k, x1, x2, y1, y2;
	cin >> m >> n >> k;
	for (int i = 0; i < k; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		for (int j = m - 1 - y1; j >= m - y2; j--) {
			for (int k = x2 - 1; k >= x1; k--) {
				if(maze[j][k] == 0) 
					maze[j][k] = 1;
			}
		}
	}
}

int main(void)
{
    input();
    solve();
	return 0;
}