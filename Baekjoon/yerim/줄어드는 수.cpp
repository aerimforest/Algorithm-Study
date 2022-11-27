// [1174] 줄어드는 수
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int n;

long long getDecreaseNumber()
{
    long long num = 0;
    queue <long long> q;
    vector <long long> decreasingNumbers;

    for(int i = 0; i <= 9; i++) {
        q.push(i);
        decreasingNumbers.push_back(i);
    }

    while(!q.empty()) {
        num = q.front(); q.pop();
        for(int i = 0; i < num%10; i++) {
            q.push(10 * num + i);
            decreasingNumbers.push_back(10 * num + i);
        }
    }

    return decreasingNumbers[n - 1];
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    // 가장 큰 줄어드는 숫자 = 1023번째 수 = 9876543210
    if(n > 1023) cout << -1 << '\n';
    else cout << getDecreaseNumber() << '\n';
}