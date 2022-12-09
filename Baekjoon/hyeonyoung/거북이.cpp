// 221209_BOJ_8911

#include <iostream>
#include <string>

using namespace std;

int T;
string ctrl;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> ctrl;

        int a = 0, aa = 0, b = 0, bb = 0;
        int x = 0, y = 0, d = 0;
        for (char c : ctrl)
        {
            if (c == 'F')
            {
                x += dx[d];
                y += dy[d];
            }
            else if (c == 'B')
            {
                x -= dx[d];
                y -= dy[d];
            }
            else if (c == 'L')
            {
                d = (d + 3) % 4;
            }
            else if (c == 'R')
            {
                d = (d + 1) % 4;
            }

            a = min(a, x);
            aa = max(aa, x);
            b = min(b, y);
            bb = max(bb, y);
        }
        cout << (aa - a) * (bb - b) << "\n";
    }

    return 0;
}
