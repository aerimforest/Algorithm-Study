#include <iostream>
#include <algorithm>
#define MAX 300000

using namespace std;

long long arr[MAX];
long long cost[MAX-1];

int main()
{
    int n, k, ans = 0;

    cin >> n >> k;

    for(int i = 0; i < n; i++)
    {
      cin >> arr[i];
    }

    sort(arr, arr+n);

    for(int i = 1; i < n; i++)
    {
        cost[i-1] = arr[i] - arr[i-1];
        //cout << cost[i-1];
    }

    sort(cost, cost+(n-1));

    for(int i = 0; i < n-k; i++)
        ans += cost[i];
    
    cout << ans;

}