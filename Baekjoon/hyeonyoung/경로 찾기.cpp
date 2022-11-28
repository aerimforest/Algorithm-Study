// 221115_BOJ_11403

#include <iostream>

using namespace std;

int N;
bool G[101][101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> G[i][j];
        }
    }

    for (int k = 0; k < N; ++k)
    {
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if (G[i][k] && G[k][j])
                {
                    G[i][j] = true;
                }
            }
        }
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cout << G[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
