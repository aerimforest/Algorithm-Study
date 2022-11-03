// 221103_BOJ_2166

#include <iostream>
#include <cmath>

using namespace std;

int N;
pair<long double, long double> coord[10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> coord[i].first >> coord[i].second;
    }

    // 외적의 크기 = 두 벡터로 이루어진 평행사변형 넓이
    long double ans = 0;
    for (int i = 1; i < N - 1; ++i)
    {
        pair<long double, long double> V1 = {coord[i].first - coord[0].first, coord[i].second - coord[0].second};
        pair<long double, long double> V2 = {coord[i + 1].first - coord[0].first, coord[i + 1].second - coord[0].second};

        ans += (V1.first * V2.second - V1.second * V2.first) / 2;
    }

    cout << fixed;
    cout.precision(1);
    cout << abs(ans);

    return 0;
}
