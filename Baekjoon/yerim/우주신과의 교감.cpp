// [1774] 우주신과의 교감
// MST, 크루스칼 알고리즘, 유니온 파인드
#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
using namespace std;

int n, m, parent[1001];
double ans;
vector<pair<int, int>> hwang;
struct Info {
    int x, y;
    double cost;
    bool operator<(const Info &ref) const {
        return this -> cost > ref.cost;
    }
};
priority_queue<Info> q;

void init()
{
    for(int i = 0; i <= 1000; i++) {
        parent[i] = i;
    }
}

int Find(int n)
{
    if(parent[n] == n) return n;
    else return parent[n] = Find(parent[n]);
}

void Union(int x, int y)
{
    int xRoot = Find(x);
    int yRoot = Find(y);
    parent[xRoot] = yRoot;
}

void input()
{
    int x, y;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> x >> y;
        hwang.push_back({x, y});
    }
    for(int i = 0; i < m; i++) {
        cin >> x >> y;
        Union(x-1, y-1);
    }
}

void findAllPath()
{
    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            double xDiff = pow(hwang[i].first - hwang[j].first, 2);
            double yDiff = pow(hwang[i].second - hwang[j].second, 2);
            q.push({i, j, sqrt(xDiff + yDiff)});
        }
    }
}

void solve()
{
    findAllPath();
    while(!q.empty()) {
        int x = q.top().x;
        int y = q.top().y;
        double cost = q.top().cost;
        q.pop();

        if(Find(x) != Find(y)) {
            Union(x, y);
            ans += cost;
        }
    }
    cout << fixed;
    cout.precision(2);
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    init();
    input();
    solve();

    return 0;
}