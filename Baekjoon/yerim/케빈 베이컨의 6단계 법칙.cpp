// [1389] 케빈 베이컨의 6단계 법칙
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

bool visited[101];
int n, m, kevinBaconNum[101], level[101];
vector<int> friendShip[101];

int bfs(int start)
{
    int kevinBacon = 0;
    queue<pair<int, int>> q;
    q.push(make_pair(start, 0));
    memset(visited, false, sizeof(visited));
    memset(level, 0, sizeof(level));

    while(!q.empty()) {
        int num = q.front().first;
        int depth = q.front().second;
        q.pop();
        for(int i = 0; i < friendShip[num].size(); i++) {
            int nextFriend = friendShip[num][i];
            if(visited[nextFriend] == false) {
                q.push(make_pair(nextFriend, depth + 1));
                level[nextFriend] = depth + 1;
                visited[nextFriend] = true;
            }
        }
    }
    
    for(int i = 1; i <= n; i++) {
        if(i != start) {
            kevinBacon += level[i];
        }
    }
    return kevinBacon;
}

int startKevinBacon()
{
    int ans = 0, minKevinBacon = 987654321;
    for(int i = 1; i <= n; i++) {
        kevinBaconNum[i] = bfs(i);
    }
    for(int i = 1; i <= n; i++) {
        if(kevinBaconNum[i] < minKevinBacon) {
            ans = i;
            minKevinBacon = kevinBaconNum[i];
        }
    }
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b;
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        cin >> a >> b;
        friendShip[a].push_back(b);
        friendShip[b].push_back(a);
    }
    cout << startKevinBacon() << '\n';

    return 0;
}