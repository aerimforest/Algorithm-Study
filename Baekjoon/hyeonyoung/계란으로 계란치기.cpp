// 221017_BOJ_16987

#include <iostream>
#include <vector>

using namespace std;

int N, ans = 0;
vector<pair<int, int>> E; // S W

void solve(int idx, vector<pair<int, int>> egg)
{
    if (idx == N)
    {
        int cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            if (egg[i].first <= 0)
            {
                cnt++;
            }
        }
        ans = max(ans, cnt);
        return;
    }

    if (egg[idx].first <= 0)
    {
        solve(idx + 1, egg);
        return;
    }

    bool flg = false;
    int S = egg[idx].first, W = egg[idx].second;
    for (int i = 0; i < N; ++i)
    {
        if (i == idx || egg[i].first <= 0)
        {
            continue;
        }

        int tmp = egg[i].first;
        egg[i].first -= W;
        egg[idx].first -= egg[i].second;
        solve(idx + 1, egg);
        egg[i].first = tmp;
        egg[idx].first = S;

        flg = true;
    }
    if (!flg)
    {
        solve(idx + 1, egg);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int s, w;
        cin >> s >> w;

        E.push_back({s, w});
    }

    solve(0, E);

    cout << ans;

    return 0;
}
