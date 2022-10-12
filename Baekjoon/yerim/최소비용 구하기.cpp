// [1916] 최소비용 구하기
#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321
using namespace std;

struct Info {
    int city;
    int cost;
    bool operator<(const Info &ref) const {
        return this->cost > ref.cost;
    }
};
int n, m, startCity, endCity;
vector<Info> vec[1001];

void input()
{
    int s, e, c;
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        cin >> s >> e >> c;
        vec[s].push_back({e, c}); // 단방향...
    }
    cin >> startCity >> endCity;
}   

void solve()
{
    int visited[1001];
    priority_queue<Info> pq;
    for(int i = 0; i <= n; i++) visited[i] = INF; // init

    visited[startCity] = 0;
    pq.push({startCity, 0});
    while (!pq.empty()) {
        Info cur = pq.top();
        pq.pop();

        if(visited[cur.city] < cur.cost) continue; // 핵심
      
        for(Info next: vec[cur.city]) {
            int newCost = cur.cost + next.cost;
            if(newCost < visited[next.city]) {
                visited[next.city] = newCost;
                pq.push({next.city, newCost});
            }
        }
    }
    cout << visited[endCity] << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}