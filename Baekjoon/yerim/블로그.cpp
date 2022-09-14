// [21921] 블로그
// 슬라이딩 윈도우
#include <iostream>
using namespace std;

int n, x, visitors[250001];

void input()
{
    cin >> n >> x;
    for(int i = 1; i <= n; i++) {
        cin >> visitors[i];
    }
}

void findMaxVisitors()
{
    int maxDays = 1;
    long long sum = 0, maxVisitors = 0;

    for(int i = 1; i <= x; i++) {
        sum += visitors[i];
    }
    maxVisitors = sum;
    for(int i = 2; i <= n - x + 1; i++) {
        sum = sum - visitors[i - 1] + visitors[i + x - 1];
        if(sum > maxVisitors) {
            maxVisitors = sum;
            maxDays = 1;
        }
        else if(sum == maxVisitors) {
            maxDays++;
        }
    }
    if(maxVisitors == 0) cout << "SAD\n";
    else {
        cout << maxVisitors << '\n';
        cout << maxDays << '\n';
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    findMaxVisitors();

    return 0;
}