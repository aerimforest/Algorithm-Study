// 221101_BOJ_2022

#include <iostream>
#include <cmath>

using namespace std;

double x, y, c;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> x >> y >> c;

    double left = 0, right = min(x, y);
    while (right - left > 1e-6)
    {
        double mid = (left + right) / 2;

        double xx = sqrt(x * x - mid * mid);
        double yy = sqrt(y * y - mid * mid);
        double h = (xx * yy) / (xx + yy);
        if (h > c)
        {
            left = mid;
        }
        else
        {
            right = mid;
        }
    }

    cout << left;

    return 0;
}
