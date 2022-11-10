// [16234] 인구 이동
#include <iostream>
#include <vector>
#include <cstring>
#include <cmath>
using namespace std;

bool visited[51][51];
int arr[51][51], n, l, r, result, cnt, sum;
int dx[4] = { 1,-1,0,0 }, dy[4] = { 0,0,1,-1 };
vector <pair <int, int>> vec;

void input()
{
    cin >> n >> l >> r;
	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
}

void dfs(int x, int y) 
{
    cnt++;
    sum += arr[x][y];
    visited[x][y] = true;
    vec.push_back(make_pair(x, y));

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (!visited[nx][ny]) {
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (abs(arr[x][y] - arr[nx][ny]) >= l && abs(arr[x][y] - arr[nx][ny]) <= r) {
					dfs(nx, ny);
				}
			}
		}
	}
}

void solve()
{
    while (true) {
		bool isOpenBorder = false;
		memset(visited, 0, sizeof(visited));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					vec.clear();
                    cnt = 0; sum = 0;
					dfs(i, j);
					
					if (cnt >= 2) {
						isOpenBorder = true;
						for (int k = 0; k < vec.size(); k++) {
                            arr[vec.at(k).first][vec.at(k).second] = sum / cnt;
                        }
					}

				}
			}
		}
		if (isOpenBorder == false) break;
		else result++;
	}
	cout << result << endl;
}

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}