// 221222_BOJ_16562

#include <iostream>

using namespace std;

int N, M, K;
pair<int, int> F[10001]; // 친구, 친구비

pair<int, int> find_friend(int x)
{
    if (F[x].first == x)
    {
        return F[x];
    }
    return F[x] = find_friend(F[x].first);
}
void make_friend(int x, int y)
{
    pair<int, int> X = find_friend(x), Y = find_friend(y);
    F[X.first].second = min(Y.second, X.second);
    F[Y.first].first = X.first;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 1; i <= N; ++i)
    {
        F[i].first = i;
        cin >> F[i].second;
    }
    for (int i = 0; i < M; ++i)
    {
        int v, w;
        cin >> v >> w;

        make_friend(v, w);
    }

    int cost = 0;
    for (int i = 1; i <= N; ++i)
    {
        // cout << F[i].first << " " << F[i].second << "\n";
        if (F[i].first == i)
        {
            cost += F[i].second;
        }
    }
    if (cost <= K)
    {
        cout << cost;
    }
    else
    {
        cout << "Oh no";
    }

    return 0;
}
