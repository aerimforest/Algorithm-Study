// 221125_BOJ_1393

#include <iostream>

using namespace std;

int xs, ys, xe, ye, dx, dy;

int gcd(int a, int b)
{
    if (b == 0)
    {
        swap(a, b);
    }

    if (a % b == 0)
    {
        return abs(b);
    }
    return gcd(a, a % b);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> xs >> ys;
    cin >> xe >> ye >> dx >> dy;

    int d = gcd(dx, dy);
    dx /= d;
    dy /= d;

    d = (xs - xe) * (xs - xe) + (ys - ye) * (ys - ye);
    while (1)
    {
        xe += dx;
        ye += dy;

        int dd = (xs - xe) * (xs - xe) + (ys - ye) * (ys - ye);
        if (dd > d)
        {
            cout << xe - dx << " " << ye - dy;
            break;
        }
        d = dd;
    }

    return 0;
}
