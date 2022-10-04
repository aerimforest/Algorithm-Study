// [1966] 프린터 큐
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

queue<pair<int, int>> q;
vector<int> priorityVec;

void solve(int n, int m)
{
    int idx = 0;
    sort(priorityVec.rbegin(), priorityVec.rend());

    while(!q.empty()) {
        auto cur = q.front();
        q.pop();
        if(cur.second == priorityVec[idx]) {
            if(cur.first == m) {
                cout << idx + 1 << '\n';
                break;
            }
            idx++;
        }
        else q.push({cur.first, cur.second});
    }
}

void init()
{
    while(!q.empty()) q.pop();
    priorityVec.clear();
}

void input()
{
    int t, n, m, priority;
    cin >> t;
    while(t--) {
        init();
        cin >> n >> m;
        for(int i = 0; i < n; i++) {
            cin >> priority;
            priorityVec.push_back(priority);
            q.push({i, priority});
        }
        solve(n, m);
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}