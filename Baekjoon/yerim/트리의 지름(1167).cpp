// [1167] 트리의 지름
// 유사문제: [1967] 트리의 지름
// bfs
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

bool visited[100001];
int V, diameter, endNode, connect[100001];
vector<pair<int, int>> vec[100001];

void input()
{
    int n1, cost, num;
    cin >> V;
    for(int i = 0; i < V; i++) {
        cin >> n1;
        while(true) {
            cin >> num;
            if(num == -1) break;
            else {
                cin >> cost;
                connect[n1]++;
                vec[n1].push_back({num, cost});
                vec[num].push_back({n1, cost});
            }
        }
    }
}

void dfs(int node, int cost)
{
    visited[node] = true;
    if(cost > diameter) {
        diameter = cost;
        endNode = node;
    }
    for(int i = 0; i < vec[node].size(); i++) {
        int next = vec[node][i].first;
        if(!visited[next]) {
            dfs(next, cost + vec[node][i].second);
        }
    }
}

void solve()
{
    dfs(1, 0); // 지름 한쪽 끝 찾기
    diameter = 0;
    memset(visited, false, sizeof(visited));
    dfs(endNode, 0); // 반대쪽 지름 끝 & 지름 찾기
    cout << diameter << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}