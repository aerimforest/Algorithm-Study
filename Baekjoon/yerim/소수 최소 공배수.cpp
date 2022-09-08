// [21919] 소수 최소 공배수
// 정수론
#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> primes;

bool isPrime(int num)
{
    for(int i = 2; i <= sqrt(num); i++) {
        if(num % i == 0) return false;
    }
    return true;
}

void input()
{
    int n, num;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> num;
        if(isPrime(num)) {
            primes.push_back(num);
        }
    }
}

long long getLCM()
{
    long long lcm = 1;
    sort(primes.begin(), primes.end());
    primes.erase(unique(primes.begin(), primes.end()), primes.end());

    for(int i = 0; i < primes.size(); i++) {
        lcm *= primes[i];
    }
    return lcm;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    if(primes.empty()) cout << "-1\n";
    else cout << getLCM() << '\n';

    return 0;
}