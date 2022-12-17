// 221217_BOJ_11758

#include <iostream>

using namespace std;

pair<int, int> P[3];
int answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 3; ++i)
    {
        cin >> P[i].first >> P[i].second;
    }

    pair<int, int> A = {P[1].first - P[0].first, P[1].second - P[0].second};
    pair<int, int> B = {P[2].first - P[1].first, P[2].second - P[1].second};
    int k = A.first * B.second - A.second * B.first;
    if (k > 0)
    {
        answer = 1;
    }
    else if (k < 0)
    {
        answer = -1;
    }
    else
    {
        answer = 0;
    }

    cout << answer;

    return 0;
}
