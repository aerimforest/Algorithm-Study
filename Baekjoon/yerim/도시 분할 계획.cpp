// [1647] 도시 분할 계획
/* 1. MST 구하기
   2. 남은 간선 중 최댓값 제거 -> 두 그룹 분할 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, maxRoad, parent[100001];
long long ans;
struct Info {
    int a, b, cost;
};
vector<Info> vec;

void input()
{
    int a, b, c;
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        vec.push_back({a, b, c});
    }
}

bool cmp(Info &A, Info &B) 
{
    return A.cost < B.cost; // cost 기준 내림차순 정렬
}

int Find(int v) 
{
    if(parent[v] == v) return v;
    else return parent[v] = Find(parent[v]);
}

void Union(int a, int b, int cost)
{
    int aRoot = Find(a);
    int bRoot = Find(b);
    if(aRoot != bRoot) {
        ans += cost;
        maxRoad = max(maxRoad, cost);
        parent[aRoot] = bRoot;
    }
}

void solve()
{
    sort(vec.begin(), vec.end(), cmp);
    for(int i = 1; i <= n; i++) { 
        parent[i] = i;
    }
    for(int i = 0; i < m; i++) {
        Union(vec[i].a, vec[i].b, vec[i].cost);
    }
    ans -= maxRoad;
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}