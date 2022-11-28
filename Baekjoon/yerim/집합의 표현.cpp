// [1717] 집합의 표현
#include <iostream>
using namespace std;

int n, m, parent[1000001];

void init()
{
    for(int i = 0; i <= n; i++) {
        parent[i] = i;
    }
}

int Find(int a)
{
    if(parent[a] == a) return a;
    else return parent[a] = Find(parent[a]);
}

void Union(int a, int b)
{
    int aRoot = Find(a);
    int bRoot = Find(b);
    parent[aRoot] = bRoot;
}

void solve()
{
    int num, a, b;
    cin >> n >> m;
    init();
    for(int i = 0; i < m; i++) {
        cin >> num >> a >> b;
        if(num == 0) Union(a, b);
        else {
            if(Find(a) == Find(b)) cout << "YES\n";
            else cout << "NO\n";
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();

    return 0;
}