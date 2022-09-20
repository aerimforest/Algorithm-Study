// [1240] 노드사이의 거리
#include <iostream>
#include <vector>
#include <queue>
#define INF 100000000
using namespace std;

int n, m, visited[10001];
struct Info {
    int node;
    int cost; // 현재 노드까지의 누적 cost
    bool operator<(const Info &ref) const { // cost 기준 오름차순 정렬
        return this->cost > ref.cost;
    }
};
vector<Info> nodes[10001];

void input()
{
    int n1, n2, cost;
    cin >> n >> m;
    for(int i = 0; i < n - 1; i++) {
        cin >> n1 >> n2 >> cost;
        nodes[n1].push_back({n2, cost});
        nodes[n2].push_back({n1, cost});
    }
}

void Dijkstra(int s, int e)
{
    priority_queue<Info> pq;
    for(int i = 1; i <= n; i++) visited[i] = INF; // init

    pq.push({s, 0});
    visited[s] = 0;

    while(!pq.empty()) {
        Info cur = pq.top();
        pq.pop();
        for(Info next: nodes[cur.node]) {
            int newCost = cur.cost + next.cost;
            if(newCost < visited[next.node]) {
                visited[next.node] = newCost;
                pq.push({next.node, newCost});
            }
            if(next.node == e) break;
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n1, n2;
    input();
    for(int i = 0; i < m; i++) {
        cin >> n1 >> n2;
        Dijkstra(n1, n2);
        cout << visited[n2] << '\n';
    }

    return 0;
}