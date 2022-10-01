// 221002_BOJ_13913

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, K;
const int MAX = 200000;
pair<int, int> visit[MAX + 1];
queue<int> Q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;

    visit[N] = {1, N};
    Q.push(N);
    while (!Q.empty())
    {
        int cur = Q.front();
        Q.pop();

        if (cur == K)
        {
            break;
        }

        if (cur + 1 <= MAX && visit[cur + 1].first == 0)
        {
            visit[cur + 1] = {visit[cur].first + 1, cur};
            Q.push(cur + 1);
        }
        if (cur >= 0 && visit[cur - 1].first == 0)
        {
            visit[cur - 1] = {visit[cur].first + 1, cur};
            Q.push(cur - 1);
        }
        if (cur * 2 <= MAX && visit[cur * 2].first == 0)
        {
            visit[cur * 2] = {visit[cur].first + 1, cur};
            Q.push(cur * 2);
        }
    }

    vector<int> ans;
    int idx = K;
    while (idx != N)
    {
        ans.push_back(idx);
        idx = visit[idx].second;
    }
    ans.push_back(idx);

    int len = ans.size() - 1;
    cout << len << "\n";
    for (int i = len; i >= 0; --i)
    {
        cout << ans[i] << " ";
    }

    return 0;
}
