//1931
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, ans = 1;
    vector<pair<int, int> > v;

    cin >> n;

    for(int i = 0; i < n; i++)
    {
        int n1, n2;
        cin >> n1 >> n2;
        v.push_back({n2, n1});
    }

    sort(v.begin(), v.end());

    int time_min = v[0].first;

    for(int i = 1; i < n; i++)
    {
        if(time_min <= v[i].second)
        {
            time_min = v[i].first;
            ans+=1;
        }
    }

    cout << ans << '\n';
}