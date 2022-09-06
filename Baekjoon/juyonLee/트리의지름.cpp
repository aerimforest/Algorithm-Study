//1967

#include <iostream>
#include <vector>

using namespace std;

vector<pair<int,int>> v[10001];
bool visited[10001] = { false };

int dfs(int x) 
{
	if (visited[x]) 
        return -1000;
	
    int sum = 0;
	visited[x] = true;
	for (int i = 0; i < v[x].size(); i++) 
    {
		int num1 = v[x][i].first;
		int num2 = v[x][i].second;
		sum = max(sum, num2 + dfs(num1));
	}
	return sum;
}

int main() 
{
	
	int n, ans = 0;
	cin >> n;
	
	for (int i = 1; i < n; i++) 
    {
		int n1, n2, n3;

		cin >> n1 >> n2 >> n3;

		v[n1].push_back(make_pair(n2, n3));
		v[n2].push_back(make_pair(n1, n3));
	}

	for (int i = 1; i <= n; i++) 
    {
		for (int j = 1; j <= n; j++) 
            visited[j] = false;
		ans = max(ans, dfs(i));
	}
	cout << ans;

}