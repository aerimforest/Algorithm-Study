// 221019_BOJ_1956

#include <iostream>
#include <vector>

using namespace std;

int V, E;
const int INF = 987654321;
int D[401][401], ans = INF;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> V >> E;
    for (int i = 1; i <= V; ++i)
    {
        for (int j = 1; j <= V; ++j)
        {
            D[i][j] = INF;
        }
    }
    for (int i = 0; i < E; ++i)
    {
        int a, b, c;
        cin >> a >> b >> c;

        D[a][b] = c;
    }

    for (int k = 1; k <= V; ++k)
    {
        for (int i = 1; i <= V; ++i)
        {
            for (int j = 1; j <= V; ++j)
            {
                D[i][j] = min(D[i][j], D[i][k] + D[k][j]);
            }
        }
    }

    for (int i = 1; i <= V; ++i)
    {
        ans = min(ans, D[i][i]);
    }
    if (ans == INF)
    {
        ans = -1;
    }
    cout << ans;

    return 0;
}
