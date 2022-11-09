// 221109_BOJ_1774

#include <iostream>
#include <cmath>
#include <queue>

using namespace std;

int N, M, parent[1001];
pair<double, double> coord[1001];
double answer = 0;

struct aisle
{
    int a, b;
    double c;

    bool operator<(const aisle &X) const
    {
        return this->c > X.c;
    }
};
priority_queue<aisle> pq;

int findParent(int x)
{
    if (x == parent[x])
    {
        return x;
    }
    return parent[x] = findParent(parent[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        cin >> coord[i].first >> coord[i].second;
        parent[i] = i;
    }
    for (int i = 1; i <= N; ++i)
    {
        for (int j = i + 1; j <= N; ++j)
        {
            pq.push({i, j, sqrt((coord[i].first - coord[j].first) * (coord[i].first - coord[j].first) + (coord[i].second - coord[j].second) * (coord[i].second - coord[j].second))});
        }
    }

    for (int i = 0; i < M; ++i)
    {
        int x, y;
        cin >> x >> y;

        parent[findParent(x)] = findParent(y);
    }
    while (!pq.empty())
    {
        int a = pq.top().a, b = pq.top().b;
        double c = pq.top().c;
        pq.pop();

        int A = findParent(a), B = findParent(b);
        if (A == B)
        {
            continue;
        }

        parent[A] = B;
        answer += c;
    }
    cout << fixed;
    cout.precision(2);
    cout << answer;

    return 0;
}
