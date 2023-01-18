// 230118_BOJ_1238

#include <iostream>

using namespace std;

int N, M, X;
int D[1001][1001], answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> X;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            D[i][j] = 987654321;
        }
        D[i][i] = 0;
    }
    for (int i = 0; i < M; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        D[a][b] = min(D[a][b], c);
    }

    for (int k = 1; k <= N; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                D[i][j] = min(D[i][j], D[i][k] + D[k][j]);
            }
        }
    }

    for (int i = 1; i <= N; i++)
    {
        answer = max(answer, D[i][X] + D[X][i]);
    }
    cout << answer;

    return 0;
}
