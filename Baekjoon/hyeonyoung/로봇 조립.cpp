// 230104_BOJ_18116

#include <iostream>

using namespace std;

int N, robot[1000001], count[1000001];

int find_robot(int x)
{
    if (robot[x] == x)
    {
        return x;
    }
    return robot[x] = find_robot(robot[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i <= 1000000; i++)
    {
        robot[i] = i;
        count[i] = 1;
    }

    cin >> N;
    while (N-- > 0)
    {
        char cmd;
        cin >> cmd;

        if (cmd == 'I')
        {
            int a, b;
            cin >> a >> b;

            int A = find_robot(a), B = find_robot(b);
            if (A != B)
            {
                robot[A] = B;
                count[B] += count[A];
            }
        }
        else if (cmd == 'Q')
        {
            int c;
            cin >> c;

            cout << count[find_robot(c)] << "\n";
        }
    }

    return 0;
}
