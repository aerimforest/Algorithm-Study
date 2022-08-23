// [13164] 행복 유치원
// 그리디
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cutPoint[300001];
int n, k, height[300001];
vector<pair<int, int>> candidateCutPoint; // <키 차이, idx>

void input()
{
    cin >> n >> k;
    for(int i = 1; i <= n; i++) {
        cin >> height[i];
    }
}

void setGroup()
{
    for(int i = 1; i <= n-1; i++) {
        candidateCutPoint.push_back(make_pair(height[i+1] - height[i], i));
    }
    sort(candidateCutPoint.rbegin(), candidateCutPoint.rend());
    for(int i = 0; i < k - 1; i++) {
        cutPoint[candidateCutPoint[i].second] = true;
    }
}

int getCost()
{
    int cost = 0, pre = 1;
    for(int i = 1; i <= n; i++) {
        if(cutPoint[i]) {
            cost += (height[i] - height[pre]);
            pre = i + 1;
        }
    }
    cost += height[n] - height[pre];
    return cost;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    setGroup();
    cout << getCost() << '\n';

    return 0;
}