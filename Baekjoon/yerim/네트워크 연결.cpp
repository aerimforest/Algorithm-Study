// [1922] 네트워크 연결
// 최소 신장 트리, 크루스칼 알고리즘, 유니온-파인드
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, ans, parent[1001];
struct Info 
{
    int a, b, cost;
};
vector<Info> vec;

bool cmp(Info &A, Info &B)
{
    return A.cost < B.cost;
}

void input()
{
    int a, b, c;
    cin >> N >> M;
    for(int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        vec.push_back({a, b, c});
    }
}

int Find(int a)
{
    if(parent[a] == a) return a;
    else return parent[a] = Find(parent[a]);
}

void Union(int a, int b, int cost)
{
    int aRoot = Find(a);
    int bRoot = Find(b);
    if(aRoot != bRoot) {
        ans += cost;
        parent[aRoot] = bRoot;
    }
}

void solve()
{
    sort(vec.begin(), vec.end(), cmp);
    for(int i = 0; i < N; i++) {
        parent[i] = i;
    }
    for(int i = 0; i < M; i++) {
        Union(vec[i].a, vec[i].b, vec[i].cost);
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    input();
    solve();
    cout << ans << '\n';

    return 0;
}