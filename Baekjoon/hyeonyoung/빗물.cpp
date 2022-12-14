// 221214_BOJ_14719

#include <iostream>

using namespace std;

int H, W, block[502];
pair<int, int> height[502];
int answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> H >> W;
    for (int i = 1; i <= W; ++i)
    {
        cin >> block[i];
    }

    for (int i = 1; i <= W; ++i)
    {
        height[i].first = max(height[i - 1].first, block[i]);
    }
    for (int i = W; i >= 1; --i)
    {
        height[i].second = max(height[i + 1].second, block[i]);
    }

    for (int i = 1; i <= W; ++i)
    {
        answer += min(height[i].first, height[i].second) - block[i];
    }
    cout << answer;

    return 0;
}
