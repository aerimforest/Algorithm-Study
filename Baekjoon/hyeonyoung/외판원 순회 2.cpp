// 220924_BOJ_10971

#include <iostream>
#include <bitset>

using namespace std;

int N, cost[11][11], D[1 << 10][11];
const int INF = 987654321;

int solve(int visit, int cur)
{
    if (D[visit][cur])
    {
        return D[visit][cur];
    }
    if (visit == (1 << N) - 1)
    {
        D[visit][cur] = cost[0][cur];
    }
    else
    {
        D[visit][cur] = INF;
        for (int next = 1; next < N; ++next)
        {
            if (visit & (1 << next))
                continue;

            D[visit][cur] = min(D[visit][cur], solve((visit | (1 << next)), next) + cost[next][cur]);
        }
    }
    return D[visit][cur];
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> cost[i][j];
            if (cost[i][j] == 0)
            {
                cost[i][j] = INF;
            }
        }
    }

    cout << solve(1, 0) << "\n";

    // for (int i = 1; i < (1 << N); i += 2)
    // {
    //     cout << bitset<4>(i) << "\t";
    //     for (int j = 0; j < N; ++j)
    //     {
    //         if (D[i][j] == INF)
    //             cout << 0 << " ";
    //         else
    //             cout << D[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    return 0;
}
