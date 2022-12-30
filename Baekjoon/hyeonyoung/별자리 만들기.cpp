// 221231_BOJ_4386

#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

int N;
pair<double, double> star[101];
int connect[101];

struct Distance
{
    int x, y;
    double d;

    bool operator<(const Distance &X) const
    {
        return this->d > X.d;
    }
};
priority_queue<Distance> pq;

int find_star(int x)
{
    if (connect[x] == x)
    {
        return x;
    }

    return connect[x] = find_star(connect[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> star[i].first >> star[i].second;
        connect[i] = i;
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            pq.push({i, j, sqrt((star[i].first - star[j].first) * (star[i].first - star[j].first) + (star[i].second - star[j].second) * (star[i].second - star[j].second))});
        }
    }

    double answer = 0;
    while (!pq.empty())
    {
        int x = pq.top().x, y = pq.top().y;
        double d = pq.top().d;
        pq.pop();

        int X = find_star(x), Y = find_star(y);
        if (X == Y)
        {
            continue;
        }

        connect[X] = Y;
        answer += d;
    }
    cout << answer;

    return 0;
}
