//2293
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n, k;
    long long dp[10001] = {0};
    int arr[101];

    cin >> n >> k;

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    
    dp[0] = 1;
    for(int i = 0; i < n; i++)
    {
        for(int j = arr[i]; j <= k; j++)
        {
            dp[j] += dp[j - arr[i]];
        }
    }
    cout << dp[k] << '\n';
}
//dp