// [1202] 보석 도둑
#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

priority_queue <pair<int, int>> tmp;
priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> jew;
vector <int> bag;

int n, k;
long long ans = 0;

void input()
{
    int a, b;
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> a >> b;
        jew.push({a, b});
    }
    for(int i = 0; i < k; i++){
        cin >> a;
        bag.push_back(a);
    }
}

void solve()
{
    sort(bag.begin(), bag.end());
    for(int i = 0; i < k; i++){
        int cur = bag[i];
        while(!jew.empty()){
            if(jew.top().first > cur) break;
            tmp.push({jew.top().second, jew.top().first});
            jew.pop();
        }
        if(tmp.empty()) continue;
        ans += tmp.top().first;
        tmp.pop();
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);

    input();
    solve();
    
    cout << ans << '\n';
    return 0;
}