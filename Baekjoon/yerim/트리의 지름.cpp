// [1967] 트리의 지름
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int n, diameter, endNode;
bool visited[10001];
vector<pair<int, int>> trees[10001];

void input()
{
    int parent, child, cost;
    cin >> n;
    for(int i = 0; i < n - 1; i++) {
        cin >> parent >> child >> cost;
        trees[parent].push_back(make_pair(child, cost));
        trees[child].push_back(make_pair(parent, cost));
    }
}

void dfs(int node, int cost)
{
    visited[node] = true;
    if(cost > diameter) {
        diameter = cost;
        endNode = node;
    }

    for(int i = 0; i < trees[node].size(); i++) {
        int next = trees[node][i].first;
        if(visited[next] == false) {
            dfs(next, cost + trees[node][i].second);
        }
    }
}

void findDiameter()
{   
    dfs(1, 0); // 루트에서 가장 먼(가중치가 큰) 노드 찾기 = endNode
    diameter = 0;
    memset(visited, false, sizeof(visited));
    dfs(endNode, 0); // endNode에서 가장 먼(가중치가 큰) 노드 찾기 = 반대쪽 지름 끝
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    findDiameter();
    cout << diameter << '\n';

    return 0;
}