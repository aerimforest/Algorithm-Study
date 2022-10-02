// [13913] 숨바꼭질 4
// parents[다음 이동 위치] = 현재 위치
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

bool visited[100001];
int n, k, seconds = 0, parents[100001]; 

void input()
{
	cin >> n >> k;
}

void bfs()
{
	visited[n] = true;
	parents[n] = n;
	queue<pair<int, int>> q;
	q.push({n, 0});
	
	while(!q.empty()) {
		int subin = q.front().first;
        int time = q.front().second;
        q.pop();
        if (subin == k) {
            seconds = time;
            return;
        }
        if (0 <= subin - 1 && visited[subin - 1] == false) {
            q.push({subin - 1, time + 1});
            visited[subin - 1] = true;
            parents[subin - 1] = subin;
        }
        if (subin + 1 <= 100000 && visited[subin + 1] == false) {
            q.push({subin + 1, time + 1});
            visited[subin + 1] = true;
            parents[subin + 1] = subin;
        }
        if (2 * subin <= 100000 && visited[2 * subin] == false) {
            q.push({2 * subin, time + 1});
            visited[2 * subin] = true;
            parents[2 * subin] = subin;
        }
	}
}

void output()
{
    int next = k;
    vector<int> ans;
	cout << seconds << '\n';
	ans.push_back(k);
	while(true) {
		if(next == n) break;
		ans.push_back(parents[next]);
		next = parents[next];
	}
	
	for(int i = ans.size() - 1 ; i >= 0 ; i--) {
		cout << ans[i] << " ";
	}
    cout << '\n';
}

int main(void)
{
	cin.tie(NULL); 
    ios_base::sync_with_stdio(false);
    
    input();
	bfs();
	output();

	return 0;
}