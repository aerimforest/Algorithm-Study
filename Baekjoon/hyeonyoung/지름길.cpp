// 221013_BOJ_1446

#include <iostream>
#include <algorithm>

using namespace std;

int N, D;
struct state
{
    int a, b, c;

    bool operator<(const state &X) const
    {
        if (this->a == X.a)
        {
            if (this->b == X.b)
            {
                return this->c < X.c;
            }
            return this->b < X.b;
        }
        return this->a < X.a;
    }
};
state shortcut[13];
int dis[10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> D;
    for (int i = 0; i < N; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;
        shortcut[i] = {a, b, c};
    }
    sort(shortcut, shortcut + N);

    for (int i = 0; i <= D; ++i)
    {
        dis[i] = i;
    }
    for (int i = 0; i < N; ++i)
    {
        int a = shortcut[i].a, b = shortcut[i].b, c = shortcut[i].c;

        if (dis[b] > dis[a] + c)
        {
            dis[b] = dis[a] + c;
            for (int j = b + 1; j <= D; ++j)
            {
                dis[j] = min(dis[j], dis[b] + (j - b));
            }
        }
    }
    cout << dis[D];

    return 0;
}
