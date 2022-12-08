// [1092] 배
// 이분 탐색, 그리디
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> crain, box;

void input()
{
    int num;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> num;
        crain.push_back(num);
    }
    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> num;
        box.push_back(num);
    }
}

void solve()
{
    int idx = 0, time = 0, transported = 0;
    sort(crain.begin(), crain.end());
    sort(box.begin(), box.end());

    if(box[m-1] > crain[n-1]) {
        cout << "-1\n";
        return;
    }
    while(transported < m) {
        for(int limit: crain) {
            int idx = upper_bound(box.begin(), box.end(), limit) - box.begin();
            if(idx > 0) {
                box.erase(box.begin() + idx - 1);
                transported++;
            }
        }
        time++;
    }
    cout << time << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}