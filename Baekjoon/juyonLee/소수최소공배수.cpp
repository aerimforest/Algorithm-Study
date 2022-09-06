//21919

#include <iostream>
#include <cmath>

using namespace std;

bool prime(long long val)
{
    if(val < 2) return false;

    for(int i = 2; i <= sqrt(val); i++)
    {
        if(val % i == 0)
            return false;
    }
    return true;
}

long long gcd(long long n1, long long n2)
{
    while(n2 > 0)
    {
        long long n3 = n1 % n2;
        n1 = n2;
        n2 = n3;
    }

    return n1;
}

long long lcm(long long n1, long long n2)
{
    return n1 * n2 / gcd(n1, n2);
}

int main()
{
    int n;
    cin >> n;

    long long ans = 1;

    for(int i = 0; i < n; i++)
    {
        int num;
        cin >> num;

        if(prime(num))
            ans = lcm(ans, num);
    }

    if(ans == 1)
        cout << -1;
    
    else
        cout << ans;
}