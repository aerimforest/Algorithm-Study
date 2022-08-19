// 220819 BOJ 1389

#include <iostream>

using namespace std;

int N, M, F[101][101];
const int INF = 987654321;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            F[i][j] = INF;
        }
        F[i][i] = 0;
    }

    for (int m = 0; m < M; ++m)
    {
        int a, b;
        cin >> a >> b;
        F[a][b] = F[b][a] = 1;
    }

    for (int k = 1; k <= N; ++k)
    {
        for (int i = 1; i <= N; ++i)
        {
            for (int j = 1; j <= N; ++j)
            {
                F[i][j] = min(F[i][j], F[i][k] + F[k][j]);
            }
        }
    }

    int ans = 0, memo = INF;
    for (int i = 1; i <= N; ++i)
    {
        int sum = 0;
        for (int j = 1; j <= N; ++j)
        {
            sum += F[i][j];
        }
        if (sum < memo)
        {
            memo = sum;
            ans = i;
        }
    }

    cout << ans;

    return 0;
}
