// 220906_BOJ_1967

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<pair<int, int>> tree[10001]; // 자식, 가중치

int ans = 0;

int DFS(int now)
{
    int ret = 0;

    for (pair<int, int> next : tree[now])
    {
        int d = DFS(next.first) + next.second;

        ans = max(ans, ret + d);
        ret = max(ret, d);
    }

    return ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i < N; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;
        tree[a].push_back({b, c});
    }

    DFS(1);

    cout << ans;

    return 0;
}
