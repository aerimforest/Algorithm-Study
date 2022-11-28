// [11403] 경로 찾기
#include <iostream>
using namespace std;
#define MAX 101

int n, matrix[MAX][MAX], visit[MAX];

void input()
{
    cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
            cin >> matrix[i][j];
        }
	}
}

void dfs(int v)
{
	for(int i = 1; i <= n; i++)
		if (matrix[v][i] == 1 && !visit[i]) {
			visit[i] = 1; 
			dfs(i);
		}
}

void solve()
{
    for (int i = 1; i <= n; i++) {
		for (int i = 1; i <= n; i++) {
            visit[i] = 0;
        }
		dfs(i);
		for (int i = 1; i <= n; i++) {
			cout << visit[i] << " ";
		}
		cout << '\n';
	}
}

int main(void)
{
    input();
    solve();

    return 0;
}