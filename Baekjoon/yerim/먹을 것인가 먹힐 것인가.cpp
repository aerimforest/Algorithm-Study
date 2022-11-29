// [7795] 먹을 것인가 먹힐 것인가
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
priority_queue<int> a, b;

void init()
{
    while(!a.empty()) a.pop();
    while(!b.empty()) b.pop();
}

void input()
{
    int size;
    cin >> n >> m;
    for(int i = 0; i < n ; i++) {
        cin >> size;
        a.push(size);
    }
    for(int i = 0; i < m ; i++) {
        cin >> size;
        b.push(size);
    }
}

int solution()
{
    int ans = 0;
    while(!a.empty() && !b.empty()) {
        if(a.top() > b.top()) {
            ans += b.size();
            a.pop();
        }
        else {
            b.pop();
        }
    }
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while(t--) {
        init();
        input();
        cout << solution() << '\n';
    }
    return 0;
}