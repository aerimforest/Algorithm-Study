// 221130_BOJ_1347

#include <iostream>
#include <string>

using namespace std;

int N;
string mov;
bool maze[120][120];

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> mov;

    int x = 60, y = 60, d = 0;
    maze[x][y] = 1;
    int x1 = 60, x2 = 60, y1 = 60, y2 = 60;
    for (int i = 0; i < N; ++i)
    {
        if (mov[i] == 'L')
        {
            d = (d + 1) % 4;
        }
        else if (mov[i] == 'R')
        {
            d = (d + 3) % 4;
        }
        else
        {
            x += dx[d];
            y += dy[d];
            maze[x][y] = 1;

            x1 = min(x1, x);
            x2 = max(x2, x);
            y1 = min(y1, y);
            y2 = max(y2, y);
        }
    }

    for (int i = x1; i <= x2; ++i)
    {
        for (int j = y1; j <= y2; ++j)
        {
            if (maze[i][j])
            {
                cout << ".";
            }
            else
            {
                cout << "#";
            }
        }
        cout << "\n";
    }

    return 0;
}
