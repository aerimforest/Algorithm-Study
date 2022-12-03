// 221203_BOJ_1647

#include <iostream>
#include <queue>

using namespace std;

int N, M;
struct road
{
    int a, b, c;

    bool operator<(const road &X) const
    {
        return this->c > X.c;
    }
};
priority_queue<road> pq;
int connect[100001], town, answer = 0;

int findAdj(int x)
{
    if (x == connect[x])
    {
        return x;
    }
    return connect[x] = findAdj(connect[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        connect[i] = i;
    }
    for (int i = 0; i < M; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;

        pq.push({a, b, c});
    }

    town = N;
    while (town > 2)
    {
        int a = pq.top().a, b = pq.top().b, c = pq.top().c;
        pq.pop();

        int A = findAdj(a), B = findAdj(b);
        if (A == B)
        {
            continue;
        }

        town--;
        answer += c;
        connect[A] = B;
    }
    cout << answer;

    return 0;
}
