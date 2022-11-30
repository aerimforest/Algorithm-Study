// [13549] 숨바꼭질 3
#include <iostream>
#include <queue>
using namespace std;

int n, k; 
bool visited[100001];

int bfs(int subin, int sister)
{
	int time = 0; 
	queue<pair<int, int> > q;
	q.push(make_pair(subin, 0));
	
	while(true) {
		int size = q.size(); 

		for (int i = 0; i < size; i++) {
			subin = q.front().first;
            int seconds = q.front().second;
			q.pop();
			if (subin == sister) {
				return seconds;
			}
            if (2 * subin <= 100000 && visited[2 * subin] == false) {
				q.push(make_pair(2 * subin, seconds));
				visited[2 * subin] = true;
			}
			if (0 <= subin - 1 && visited[subin - 1] == false) {
				q.push(make_pair(subin - 1, seconds + 1));
				visited[subin - 1] = true;
			}
			if (subin + 1 <= 100000 && visited[subin + 1] == false) {
				q.push(make_pair(subin + 1, seconds + 1));
				visited[subin + 1] = true;
			}
		}
	}
}

void input()
{
	cin >> n >> k;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
	cout << bfs(n, k);

    return 0;
}