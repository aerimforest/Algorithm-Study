//2343

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, m;

    cin >> n >> m;
    vector<int> v(n);

    int sumL = 0, maxL = 0;
    for(int i = 0; i < n; i++)
    {
        cin >> v[i];

        if(maxL < v[i])
            maxL = v[i];
        
        sumL += v[i];
    }

    int left = maxL, right = sumL;

    while(left <= right)
    {
        int mid = (left + right) / 2;
        int cnt = 0, sum = 0;

        for(int i = 0; i < n; i++)
        {
            sum += v[i];
        
        if(sum > mid)
        {
            sum = v[i];
            cnt+=1;
        }
    }

    if(cnt >= m)
        left = mid + 1;
    else  
        right = mid - 1;

    }

    cout << left << '\n';
}

//이진탐색