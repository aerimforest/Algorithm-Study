// [1976] 여행 가자
// 유니온 파인드
#include <iostream>
using namespace std;

int m, parent[201], path[1001];

int find(int a)
{
    if(parent[a] == a) return a;
    else return parent[a] = find(parent[a]);
}

void Union(int a, int b)
{
    int aRoot = find(a);
    int bRoot = find(b);
    parent[aRoot] = bRoot;
}

void input()
{
    int n, state;
    cin >> n >> m;
    for(int i = 1; i <= n; i++) {
        parent[i] = i;
    }
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            cin >> state;
            if(state == 1) {
                Union(i, j);
            }
        }
    }
    for(int i = 0; i < m; i++) {
        cin >> path[i];
    }
}

void solve()
{
    bool flag = true;
    for(int i = 0; i < m - 1; i++) {
        int aRoot = find(path[i]);
        int bRoot = find(path[i+1]);
        if(aRoot != bRoot) {
            flag = false;
            break;
        }
    }
    if(flag) cout << "YES\n";
    else cout << "NO\n";
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();
    
    return 0;
}