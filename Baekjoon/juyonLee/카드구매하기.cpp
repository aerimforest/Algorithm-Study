//11052

#include <iostream>
#include <algorithm>
#define MAX 1001

using namespace std;

int main()
{
    int dp[MAX] = {0};
    int n;

    cin >> n;

    for(int i = 1; i <= n; i++)
        cin >> dp[i];

    
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= i; j++)
            dp[i] = max(dp[i], dp[i - j] + dp[j]);
    }

    cout << dp[n];
}