// 221227_BOJ_6497

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int M, N;
struct house
{
    int x, y, cost;

    bool operator<(const house &X) const
    {
        return this->cost > X.cost;
    }
};
int connect[200001], answer = 0;
priority_queue<house> pq;

int find_house(int x)
{
    if (connect[x] == x)
    {
        return x;
    }

    return connect[x] = find_house(connect[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (1)
    {
        cin >> M >> N;
        if (M == 0 && N == 0)
        {
            break;
        }

        // init
        answer = 0;
        pq = {};
        for (int i = 0; i < M; ++i)
        {
            connect[i] = i;
        }

        // road
        for (int i = 0; i < N; ++i)
        {
            int x, y, z;
            cin >> x >> y >> z;
            pq.push({x, y, z});
            answer += z;
        }

        // connect city
        while (!pq.empty())
        {
            int x = pq.top().x, y = pq.top().y, z = pq.top().cost;
            pq.pop();

            int X = find_house(x), Y = find_house(y);
            if (X == Y)
            {
                continue;
            }

            answer -= z;
            connect[X] = Y;
        }
        cout << answer << "\n";
    }

    return 0;
}
