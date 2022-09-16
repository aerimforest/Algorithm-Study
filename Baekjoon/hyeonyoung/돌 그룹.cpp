// 220916_BOJ_12886

#include <iostream>
#include <queue>

using namespace std;

int A, B, C, D;
bool bfs[1501][1501], ans = false;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> A >> B >> C;
    D = (A + B + C);

    if (D % 3 == 0)
    {
        queue<pair<int, int>> Q;
        int x = min(A, min(B, C)), y = max(A, max(B, C));
        bfs[x][y] = 1;
        Q.push({x, y});
        while (!Q.empty())
        {
            int a = Q.front().first, c = Q.front().second, b = D - a - c;
            Q.pop();

            if (a == b && b == c)
            {
                ans = true;
                break;
            }

            int nx[] = {a, a, b}, ny[] = {b, c, c};
            for (int k = 0; k < 3; ++k)
            {
                if (nx[k] == ny[k])
                {
                    continue;
                }

                int aa = ny[k] - nx[k], bb = nx[k] + nx[k], cc = D - aa - bb;
                int X = min(aa, min(bb, cc)), Y = max(aa, max(bb, cc));
                if (bfs[X][Y] == 0)
                {
                    bfs[X][Y] = 1;
                    Q.push({X, Y});
                }
            }
        }
    }
    cout << ans;

    return 0;
}
