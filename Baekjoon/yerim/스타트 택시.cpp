// [19238] 스타트 택시
#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

struct Info {
	int y;
	int x;
};
Info taxi;
vector <Info> people;
vector <Info> dest;
int n, m, f, arr[21][21], visited[21][21];
int dy[4] = { 0, 1, 0, -1 }, dx[4] = { 1, 0, -1, 0 };

void input()
{
    cin >> n >> m >> f;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
        }
    }

	cin >> taxi.y >> taxi.x;
	for (int i = 0; i < m; i++) {
		int t1, t2, t3, t4;
		cin >> t1 >> t2 >> t3 >> t4;
		people.push_back({ t1,t2 });
		dest.push_back({ t3,t4 });
	}
}

void bfs(int y, int x) {
	queue <pair<int, int>> q;
	q.push(make_pair(y, x));
	visited[y][x] = 1;

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
				if (arr[ny][nx] == 0 && visited[ny][nx] == 0) {
					q.push(make_pair(ny, nx));
					visited[ny][nx] = visited[y][x] + 1;
				}
			}
		}
	}
}

void solve()
{
    for (int i = 0; i < m; i++) {
		memset(visited, 0, sizeof(visited));
		bfs(taxi.y, taxi.x);

		int dis = 1000000000;
		int ny = 0, nx = 0, index = -1;
		for (int j = 0; j < people.size(); j++) {
			int y = people[j].y;
			int x = people[j].x;
			if (visited[y][x] < dis) {
				ny = y;
				nx = x;
				index = j;
				dis = visited[y][x];
			}
			else if (visited[y][x] == dis) {
				if (ny > y) {
					ny = y;
					nx = x;
					index = j;
				}
				else if (nx > x && ny == y) {
					ny = y;
					nx = x;
					index = j;
				}
			}
		}
		people.erase(people.begin() + index);
		taxi.y = ny, taxi.x = nx;
		f -= (visited[ny][nx] - 1);
		if (visited[ny][nx] == 0) {
			f = -1;
			break;
		}
		if (f <= 0) break;

		memset(visited, 0, sizeof(visited));
		bfs(taxi.y, taxi.x);
	
		int dy = dest[index].y;
		int dx = dest[index].x;
		if (visited[dy][dx] == 0) {
			f = -1;
			break;
		}
		taxi.y = dy, taxi.x = dx;
		dest.erase(dest.begin() + index);
		f -= (visited[dy][dx] - 1);
		if (f < 0) break;
		f += ((visited[dy][dx] - 1) * 2);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

    input();
    solve();

	if (f <= 0) cout << -1 << endl;
	else cout << f << endl;
    
	return 0;
}