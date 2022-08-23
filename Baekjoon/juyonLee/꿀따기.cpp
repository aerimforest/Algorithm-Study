#include <iostream>
#define MAX 100002

using namespace std;

int n, ans = -1;
int h[MAX];
int hleft[MAX];
int hright[MAX];
//꿀 벌 벌
//벌 꿀 벌
//벌 벌 꿀

int main()
{
    cin >> n;

    for(int i = 1; i <= n; i++)
    {
        cin >> h[i];

    }

    for(int i = 1; i <= n; i++)
    {
        hleft[i] = hleft[i-1] + h[i];
    }

    for(int i = n; i >= 1; i--)
    {
        hright[i] = hright[i + 1] + h[i];
    }
//꿀 벌 벌
    for(int i = n-1; i >= 2; i--)
    {
        ans = max(ans, hright[1]-hright[n] + hright[1]-hright[i] - h[i]);
    }

//벌 꿀 벌
    for(int i = 2; i < n; i++)
    {
        ans = max(ans, hleft[i]-h[1] + hright[i]-h[n]);
    }

//벌 벌 꿀
    for(int i = 2; i < n; i++)
    {
        ans = max(ans, hleft[n]-hleft[1] + hleft[n]-hleft[i] - h[i]);
    }

    cout << ans << '\n';
    
}